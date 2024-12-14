package fol1.fol2.NotificationServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fol1.fol2.categorieServices.CategorieLocale;
import fol1.fol2.categorieServices.CategorieRemote;
import fol1.fol2.entities.Notification;

@Stateless
public class NotificationImpl implements NotificationLocale,NotificationRemote {

	  @PersistenceContext(unitName = "SalleEjb")
	    private EntityManager em;
  

  public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Notification addNotification(Notification noti) {
	    try {
	        // Ajouter une notification dans la base de données
	        em.persist(noti);
	        return noti; // Retourner la notification persistée
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Erreur lors de l'ajout de la notification : " + e.getMessage());
	    }
	}

	@Override
	public List<Notification> afficheNotifications() {
	    try {
	        // Récupérer toutes les notifications
	    	List<Notification> list=em.createQuery("SELECT n FROM Notification n", Notification.class).getResultList();
	    	
	        return list;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Erreur lors de l'affichage des notifications : " + e.getMessage());
	    }
	}

	@Override
	public void removeNotifications() {
	    try {
	        // Supprimer toutes les notifications
	        em.createQuery("DELETE FROM Notification").executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Erreur lors de la suppression des notifications : " + e.getMessage());
	    }
	}

	@Override
	public void removeNotification(int id) {
	    try {
	        // Trouver la notification dans la base de données
	        Notification noti = em.find(Notification.class, id);
	        if (noti != null) {
	            // Supprimer la notification
	            em.remove(noti);
	            System.out.println("Notification avec l'ID " + id + " supprimée avec succès.");
	        } else {
	            System.out.println("Aucune notification trouvée avec l'ID " + id);
	        }
	    } catch (Exception e) {
	        System.err.println("Erreur lors de la suppression de la notification : " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	
}
