package manager;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Country;

@Component
public class CountryManager {

	@Autowired
	EntityManager entityManager;

	protected void create(String language, String countryName) {
		Country country = new Country();

		country.setLanguage(language);
		country.setCountryName(countryName);

		Session session = this.entityManager.unwrap(Session.class);
		session.beginTransaction();

		session.save(country);

		session.getTransaction().commit();
		session.close();

	}

}
