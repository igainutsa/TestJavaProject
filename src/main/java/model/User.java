package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	private long id;
	private String userName;
	private Location locationId;
	private UserGroup userGroupId;
	private Set<Sessionn> sassionn = new HashSet<Sessionn>();

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ManyToOne
	@JoinColumn(name = "location_id")
	public Location getLocationId() {
		return locationId;
	}

	public void setLocationId(Location locationId) {
		this.locationId = locationId;
	}

	@ManyToOne
	@JoinColumn(name = "user_group_id")
	public UserGroup getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(UserGroup userGroupId) {
		this.userGroupId = userGroupId;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Sessionn> getSassionn() {
		return sassionn;
	}

	public void setSassionn(Set<Sessionn> sassionn) {
		this.sassionn = sassionn;
	}

}
