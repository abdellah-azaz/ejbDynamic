package fol1.fol2.categorieServices;

import java.util.List;

import javax.ejb.Local;

import fol1.fol2.entities.Categorie;

@Local
public interface CategorieLocale {
    Categorie addCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie);
    Categorie getCategorie(int id);
    List<Categorie> afficheCategories();
    void removeCategorie(int id);
}







