package fol1.fol2.FiliereService;


import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import fol1.fol2.entities.Filiere;
import fol1.fol2.entities.User;

@Local
public interface FiliereLocale {
    Filiere addFiliere(Filiere filiere);
    Filiere updateFiliere(Filiere filiere);
    Filiere getFiliere(int id);
    List<Filiere> afficheFilieres();
    void removeFiliere(int id);
}

