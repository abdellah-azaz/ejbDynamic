package fol1.fol2.services;

import fol1.fol2.entities.Salle;
import java.util.List;

import javax.ejb.Local;

@Local
public interface SalleLocale {
    Salle addSalle(Salle salle);
    Salle updateSalle(Salle salle);
    Salle getSalle(int id);
    List<Salle> afficheSalles();
    void removeSalle(int id);
}

