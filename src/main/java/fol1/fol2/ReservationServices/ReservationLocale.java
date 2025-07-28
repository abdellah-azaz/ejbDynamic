package fol1.fol2.ReservationServices;


import java.util.List;

import javax.ejb.Local;

import fol1.fol2.entities.Categorie;
import fol1.fol2.entities.Reservation;

@Local
public interface ReservationLocale {
    Reservation addReservation(Reservation reserv);
    Reservation updateReservation(Reservation reserv);
    Reservation getReservation(int id);
    List<Reservation> afficheReservations();
    void removeReservation(int id);
}
