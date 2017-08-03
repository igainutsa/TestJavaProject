package manager;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Location;
import model.User;
import model.UserGroup;

@Component
public class UserManager {

	@Autowired
	EntityManager entityManager;

	public void create(String userName, long locationId, long userGroupId) {

		User user = new User();
		Location location = new Location();
		UserGroup userGroup = new UserGroup();
		location.setId(locationId);
		userGroup.setId(userGroupId);

		user.setUserName(userName);
		user.setLocationId(location);
		user.setUserGroupId(userGroup);

		Session session = this.entityManager.unwrap(Session.class);
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();

	}

	public User getUser(long userId) {
		Session session = this.entityManager.unwrap(Session.class);
		User user = session.get(User.class, userId);
		return user;
	}

}
