package fol1.fol2.NotificationProfServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fol1.fol2.NotificationServices.NotificationLocale;
import fol1.fol2.NotificationServices.NotificationRemote;
import fol1.fol2.entities.Notification;
import fol1.fol2.entities.NotificationProf;

@Stateless
public class NotificationProfImpl implements NotificationProfLocale,NotificationProfRemote {

	  @PersistenceContext(unitName = "SalleEjb")
	    private EntityManager em;
  

  public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public NotificationProf addNotificationProf(NotificationProf noti) {
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
	public List<NotificationProf> afficheNotificationProf() {
	    try {
	        // Récupérer toutes les notifications
	    	List<NotificationProf> list=em.createQuery("SELECT n FROM NotificationProf n", NotificationProf.class).getResultList();
	    	
	        return list;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Erreur lors de l'affichage des notifications : " + e.getMessage());
	    }
	}

	@Override
	public void removeNotificationProfs() {
	    try {
	        // Supprimer toutes les notifications
	        em.createQuery("DELETE FROM NotificationProf").executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Erreur lors de la suppression des notifications : " + e.getMessage());
	    }
	}

	@Override
	public void removeNotificationProf(int id) {
	    try {
	        // Trouver la notification dans la base de données
	        NotificationProf noti = em.find(NotificationProf.class, id);
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

