package fol1.fol2.categorieServices;

import java.util.List;

import javax.ejb.Local;

import fol1.fol2.entities.Categorie;

<<<<<<< HEAD
//deuxieme comment 
//3 eme

//ajout d un comments  
//4 eme

//5 eme

=======
>>>>>>> 421983fba5e8941957aef789f430cb281e35c120
@Local
public interface CategorieLocale {
    Categorie addCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie);
    Categorie getCategorie(int id);
    List<Categorie> afficheCategories();
    void removeCategorie(int id);
}







