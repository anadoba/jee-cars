package pl.nadoba.cars.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.nadoba.cars.domain.Car;
import pl.nadoba.cars.domain.Person;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class SellingManager {

	@PersistenceContext
	EntityManager em;
/*
	public void sellCar(Long personId, Long carId) {

		Person person = em.find(Person.class, personId);
		Car car = em.find(Car.class, carId);
		car.setSold(true);

		person.getCars().add(car);
	}
*/
	@SuppressWarnings("unchecked")
	public List<Car> getAvailableCars() {
		return em.createNamedQuery("car.unsold").getResultList();
	}
/*
	public void disposeCar(Person person, Car car) {

		person = em.find(Person.class, person.getId());
		car = em.find(Car.class, car.getId());

		Car toRemove = null;
		// lazy loading here (person.getCars)
		for (Car aCar : person.getCars())
			if (aCar.getId().compareTo(car.getId()) == 0) {
				toRemove = aCar;
				break;
			}

		if (toRemove != null)
			person.getCars().remove(toRemove);
		
		car.setSold(false);
	}
*/
}
