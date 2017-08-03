package manager;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.UserGroup;

@Component
public class UserGroupManager {

	@Autowired
	EntityManager entityManager;

	protected void create(String groupName) {

		UserGroup userGroup = new UserGroup();
		userGroup.setGroupName(groupName);
		Session session = this.entityManager.unwrap(Session.class);
		session.beginTransaction();
		session.save(userGroup);
		session.getTransaction().commit();
		session.close();

	}

}
