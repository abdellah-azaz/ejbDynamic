package fol1.fol2.ReservationAttentService;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fol1.fol2.entities.Reservation;
import fol1.fol2.entities.ReservationAttent;
@Stateless
public class AttenteImpl implements AttenteLocale,AttenteRemote{

	  @PersistenceContext(unitName = "SalleEjb")
	    private EntityManager em;


public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public ReservationAttent addReservationAtt(ReservationAttent reserv) {
		 em.persist(reserv);
	      return reserv;
	}
	
	@Override
	public List<ReservationAttent> getReservationsBySalleId(int salle_id) {
	    return em.createQuery(
	            "SELECT r FROM ReservationAttent r WHERE r.salle.id = :salle_id", 
	            ReservationAttent.class)
	            .setParameter("salle_id", salle_id)
	            .getResultList();
	}


	@Override
	public ReservationAttent updateReservationAtt(ReservationAttent reserv) {
		  ReservationAttent oldRes=em.find(ReservationAttent.class, reserv.getId());
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
	public ReservationAttent getReservation(int id) {
		// TODO Auto-generated method stub
		 return em.find(ReservationAttent.class, id);
	}

	@Override
	public List<ReservationAttent> afficheReservationsAtt() {
		// TODO Auto-generated method stub
		 return em.createQuery("SELECT r FROM ReservationAttent r", ReservationAttent.class).getResultList();
	}

	@Override
	public void removeReservationAtt(int id) {
		 ReservationAttent reserv = em.find(ReservationAttent.class, id);
	      if (reserv != null) {
	          em.remove(reserv);
	      }
		
	}

}
