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

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@Table(name = "sesionn")
public class Sessionn {
	private long id;
	private LocalDateTime dateOpened;
	private LocalDateTime dateClosed;
	private User user;
	private Set<Request> request = new HashSet<Request>();

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "date_opened")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	public LocalDateTime getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(LocalDateTime dateOpened) {
		this.dateOpened = dateOpened;
	}

	@Column(name = "date_closed")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	public LocalDateTime getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(LocalDateTime dateClosed) {
		this.dateClosed = dateClosed;
	}

	@OneToMany(mappedBy = "sessionnId", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Request> getRequest() {
		return this.request;
	}

	public void setRequest(Set<Request> request) {
		this.request = request;
	}

}
