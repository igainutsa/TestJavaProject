package manager;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Sessionn;
import model.User;

@Component
public class SessionnManager {

	@Autowired
	EntityManager entityManager;

	protected void create(long userId, LocalDateTime dateOpened, LocalDateTime dateClosed) {

		Sessionn sessionn = new Sessionn();
		User user = new User();
		user.setId(userId);

		sessionn.setUser(user);
		sessionn.setDateOpened(dateOpened);
		sessionn.setDateClosed(dateClosed);

		Session session = this.entityManager.unwrap(Session.class);
		session.beginTransaction();

		session.save(sessionn);

		session.getTransaction().commit();
		session.close();

	}

}
