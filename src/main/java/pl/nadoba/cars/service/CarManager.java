package pl.nadoba.cars.service;

import pl.nadoba.cars.domain.Car;
import pl.nadoba.cars.domain.Make;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CarManager {

    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Car> getAllCars() {
        return em.createNamedQuery("car.all").getResultList();
    }

    public Car getCarById(Long id) {
        return em.find(Car.class, id);
    }

    public void add(Car car) {
        car.setId(null);
        em.persist(car);
    }

    public void update(Car car) {
        em.merge(car);
    }

    public void delete(Car car) {
        em.remove(em.find(Car.class, car.getId()));
    }
}
