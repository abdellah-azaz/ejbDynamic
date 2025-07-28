package fol1.fol2.services;


import fol1.fol2.entities.Salle;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface SalleRemote {
    Salle addSalle(Salle salle);
    Salle updateSalle(Salle salle);
    Salle getSalle(int id);
    List<Salle> afficheSalles();
    void removeSalle(int id);
}
