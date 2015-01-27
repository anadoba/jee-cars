package pl.nadoba.cars.service;

import pl.nadoba.cars.domain.Engine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EngineManager {
    
    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Engine> getAllEngines() {
        return em.createNamedQuery("engine.all").getResultList();
    }

    public Engine getEngineById(Long id) {
        return em.find(Engine.class, id);
    }

    public void add(Engine engine) {
        engine.setId(null);
        em.persist(engine);
    }

    public void update(Engine engine) {
        em.merge(engine);
    }

    public void delete(Engine engine) {
        em.remove(em.merge(engine));
    }
}
