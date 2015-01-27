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

    public void add(Engine Engine) {
        Engine.setId(null);
        em.persist(Engine);
    }

    public void update(Engine Engine) {
        em.merge(Engine);
    }

    public void delete(Engine Engine) {
        em.remove(em.merge(Engine));
    }
}
