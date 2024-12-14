package fol1.fol2.categorieServices;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import fol1.fol2.entities.Categorie;

@Remote
public interface CategorieRemote {
    Categorie addCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie);
    Categorie getCategorie(int id);
    List<Categorie> afficheCategories();
    void removeCategorie(int id);
}
