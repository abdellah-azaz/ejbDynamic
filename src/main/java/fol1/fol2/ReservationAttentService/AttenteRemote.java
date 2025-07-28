package fol1.fol2.ReservationAttentService;

import java.util.List;

import javax.ejb.Remote;

import fol1.fol2.entities.ReservationAttent;
@Remote
public interface AttenteRemote {
	 ReservationAttent addReservationAtt(ReservationAttent reserv);
	    ReservationAttent updateReservationAtt(ReservationAttent reserv);
	    ReservationAttent getReservation(int id);
	    List<ReservationAttent> afficheReservationsAtt();
	    void removeReservationAtt(int id);
	    List<ReservationAttent> getReservationsBySalleId(int salle_id);
}
