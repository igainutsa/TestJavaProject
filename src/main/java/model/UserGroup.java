package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_group")
public class UserGroup {
	private long id;
	private String groupName;
	private Set<User> user = new HashSet<User>();

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "group_name")
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@OneToMany(mappedBy = "userGroupId", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<User> getUser() {
		return this.user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

}
