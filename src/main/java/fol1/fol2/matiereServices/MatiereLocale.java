package fol1.fol2.matiereServices;

import java.util.List;

import javax.ejb.Local;

import fol1.fol2.entities.Categorie;
import fol1.fol2.entities.Matiere;

@Local
public interface MatiereLocale {
    Matiere addMatiere(Matiere matiere);
    Matiere updateMatiere(Matiere matiere);
    Matiere getMatiere(int id);
    List<Matiere> afficheMatieres();
    void removeMatiere(int id);
}
