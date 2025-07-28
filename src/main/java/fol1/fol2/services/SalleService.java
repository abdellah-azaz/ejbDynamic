package fol1.fol2.services;



import fol1.fol2.entities.Salle;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SalleService implements SalleLocale, SalleRemote {
	  @PersistenceContext(unitName = "SalleEjb")
	    private EntityManager em;
    

    public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
    public Salle addSalle(Salle salle) {
        em.persist(salle);
        return salle;
    }

    @Override
    public Salle updateSalle(Salle salle) {
        return em.merge(salle);
    }

    @Override
    public Salle getSalle(int id) {
        return em.find(Salle.class, id);
    }

    @Override
    public List<Salle> afficheSalles() {
        return em.createQuery("SELECT s FROM Salle s", Salle.class).getResultList();
    }

    @Override
    public void removeSalle(int id) {
        Salle salle = em.find(Salle.class, id);
        if (salle != null) {
            em.remove(salle);
        }
    }
}
