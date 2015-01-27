package pl.nadoba.cars.service;

import pl.nadoba.cars.domain.Make;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MakeManager {

    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Make> getAllMakes() {
        return em.createNamedQuery("make.all").getResultList();
    }

    public Make getMakeById(Long id) {
        return em.find(Make.class, id);
    }

    public void add(Make make) {
        make.setId(null);
        em.persist(make);
    }

    public void update(Make make) {
        em.merge(make);
    }

    public void delete(Make make) {
        em.remove(em.merge(make));
    }
}
