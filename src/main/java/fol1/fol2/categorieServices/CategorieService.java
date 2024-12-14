package fol1.fol2.categorieServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fol1.fol2.entities.Categorie;
import fol1.fol2.entities.Salle;
@Stateless
public class CategorieService implements CategorieLocale,CategorieRemote {

	  @PersistenceContext(unitName = "SalleEjb")
	    private EntityManager em;
  

  public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
  public Categorie addCategorie(Categorie categorie) {
      em.persist(categorie);
      return categorie;
  }

  @Override
  public Categorie updateCategorie(Categorie categorie) {
      return em.merge(categorie);
  }

  @Override
  public Categorie getCategorie(int id) {
      return em.find(Categorie.class, id);
  }

  @Override
  public List<Categorie> afficheCategories() {
      return em.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
  }

  @Override
  public void removeCategorie(int id) {
      Categorie categorie = em.find(Categorie.class, id);
      if (categorie != null) {
          em.remove(categorie);
      }
  }

}
