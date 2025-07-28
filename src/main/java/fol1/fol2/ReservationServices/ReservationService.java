package fol1.fol2.ReservationServices;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fol1.fol2.entities.Categorie;
import fol1.fol2.entities.Reservation;
import fol1.fol2.entities.Salle;
@Stateless
public class ReservationService implements ReservationLocale,ReservationRemote {

	  @PersistenceContext(unitName = "SalleEjb")
	    private EntityManager em;
  

  public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
  public Reservation addReservation(Reservation reserv) {
      em.persist(reserv);
      return reserv;
  }

  @Override
  public Reservation updateReservation(Reservation reserv) {
	  Reservation oldRes=em.find(Reservation.class, reserv.getId());
	  if(oldRes != null) {
		 
		  oldRes.setFiliere(reserv.getFiliere());
		  oldRes.setSalle(reserv.getSalle());
		  oldRes.setUser(reserv.getUser());
		  em.merge(oldRes);
		  return oldRes;
	  }
	  else {
		  throw new IllegalArgumentException("la reservation avec l id :"+reserv.getId()+"nexiste pas");
	  }
      
  }

  @Override
  public Reservation getReservation(int id) {
      return em.find(Reservation.class, id);
  }

  @Override
  public List<Reservation> afficheReservations() {
      return em.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
  }

  @Override
  public void removeReservation(int id) {
      Reservation reserv = em.find(Reservation.class, id);
      if (reserv != null) {
          em.remove(reserv);
      }
  }

}

