package manager;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Country;
import model.Location;

@Component
public class LocationManager {

	@Autowired
	EntityManager entityManager;

	protected void create(String locationName, long countryId, BigDecimal latitude, BigDecimal longitude) {

		Location location = new Location();
		Country country = new Country();
		country.setId(countryId);

		location.setLocationName(locationName);
		location.setCountry(country);
		location.setLatitude(latitude);
		location.setLongitude(longitude);

		Session session = this.entityManager.unwrap(Session.class);
		session.beginTransaction();

		session.save(location);

		session.getTransaction().commit();
		session.close();

	}

}
