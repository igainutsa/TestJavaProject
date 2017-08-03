package manager;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Request;
import model.Sessionn;

@Component
public class RequestManager {

	@Autowired
	EntityManager entityManager;

	protected void create(String url, String method, String params, long sessionnId) {
		// Country country = new Country();

		Request request = new Request();
		Sessionn sessionn = new Sessionn();
		sessionn.setId(sessionnId);

		request.setUrl(url);
		request.setMethod(method);
		request.setParams(params);
		request.setSessionnId(sessionn);

		Session session = this.entityManager.unwrap(Session.class);
		session.beginTransaction();

		session.save(request);

		session.getTransaction().commit();
		session.close();

	}

}
