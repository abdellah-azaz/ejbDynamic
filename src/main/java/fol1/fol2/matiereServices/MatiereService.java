package fol1.fol2.matiereServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fol1.fol2.entities.Categorie;
import fol1.fol2.entities.Matiere;
@Stateless
public class MatiereService implements MatiereLocale,MatiereRemote {
	
	  @PersistenceContext(unitName = "SalleEjb")
	    private EntityManager em;


public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
public Matiere addMatiere(Matiere matiere) {
    em.persist(matiere);
    return matiere;
}

@Override
public Matiere updateMatiere(Matiere matiere) {
    return em.merge(matiere);
}

@Override
public Matiere getMatiere(int id) {
    return em.find(Matiere.class, id);
}

@Override
public List<Matiere> afficheMatieres() {
    return em.createQuery("SELECT m FROM Matiere m", Matiere.class).getResultList();
}

@Override
public void removeMatiere(int id) {
    Matiere matiere = em.find(Matiere.class, id);
    if (matiere != null) {
        em.remove(matiere);
    }
}

}
