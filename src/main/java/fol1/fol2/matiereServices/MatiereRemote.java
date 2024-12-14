package fol1.fol2.matiereServices;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import fol1.fol2.entities.Matiere;

@Remote
public interface MatiereRemote {
    Matiere addMatiere(Matiere matiere);
    Matiere updateMatiere(Matiere matiere);
    Matiere getMatiere(int id);
    List<Matiere> afficheMatieres();
    void removeMatiere(int id);
}
