package fol1.fol2.FiliereService;



import fol1.fol2.entities.Filiere;
import fol1.fol2.entities.Reservation;
import fol1.fol2.entities.Salle;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FiliereService implements FiliereLocale, FiliereRemote {
	  @PersistenceContext(unitName = "SalleEjb")
	    private EntityManager em;
    

    public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
    public Filiere addFiliere(Filiere filiere) {
        em.persist(filiere);
        return filiere;
    }

	 @Override
	  public Filiere updateFiliere(Filiere filiere) {
		  Filiere oldFil=em.find(Filiere.class, filiere.getCode());
		  if(oldFil != null) {
			  oldFil.setEffectif(filiere.getEffectif());
			  oldFil.setLibelle(filiere.getLibelle());
			
			  em.merge(oldFil);
			  return oldFil;
		  }
		  else {
			  throw new IllegalArgumentException("la filiere avec l id :"+filiere.getCode()+"nexiste pas");
		  }
	      
	  }

    @Override
    public Filiere getFiliere(int id) {
        return em.find(Filiere.class, id);
    }

    @Override
    public List<Filiere> afficheFilieres() {
        return em.createQuery("SELECT f FROM Filiere f", Filiere.class).getResultList();
    }

    @Override
    public void removeFiliere(int id) {
        Filiere filiere = em.find(Filiere.class, id);
        if (filiere != null) {
            em.remove(filiere);
        }
    }
}

