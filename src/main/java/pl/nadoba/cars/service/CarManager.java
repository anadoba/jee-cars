package pl.nadoba.cars.service;

import pl.nadoba.cars.domain.Car;
import pl.nadoba.cars.domain.Engine;
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

    @SuppressWarnings("unchecked")
    public List<Car> getFastCars() {
        return em.createNamedQuery("car.fastOnes").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Car> getCarsFrom(String country) {
        return em.createNamedQuery("car.byCountry").setParameter("country", "%"+country+"%").getResultList();
    }

    public Car getCarById(Long id) {
        return em.find(Car.class, id);
    }

    public void add(Car car, Long engineId, Long makeId) {
        car.setId(null);
        em.merge(car);

        Engine engine = em.find(Engine.class, engineId);

        Make make = em.find(Make.class, makeId);

        int size = em.createNamedQuery("car.all").getResultList().size();
        Car carr = (Car) em.createNamedQuery("car.all").getResultList().get(size-1);

        make.getCars().add(em.find(Car.class, carr.getId()));

        engine.getCars().add(em.find(Car.class, carr.getId()));
    }

    public void update(Car car) {
        em.merge(car);
    }

    public void delete(Car car) {
        em.remove(em.find(Car.class, car.getId()));
    }
}
