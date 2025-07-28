package fol1.fol2.entities;


import java.io.Serializable;
import javax.persistence.*;
//...
@Entity
@Table(name = "charge")
public class Charge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Clé primaire pour l'entité Charge

    @ManyToOne
    @JoinColumn(name = "matiere_code") // Colonne de clé étrangère pour Matiere
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "filiere_code") // Colonne de clé étrangère pour Filiere
    private Filiere filiere;
    
    @ManyToOne
    @JoinColumn(name = "categorie_code") // Colonne de clé étrangère pour Filiere
    private Categorie categorie;

    private int charge; // L'attribut supplémentaire

    // Constructeurs
    public Charge() {
    }

    public Charge(Matiere matiere, Filiere filiere, int charge) {
        this.matiere = matiere;
        this.filiere = filiere;
        this.charge = charge;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }
}

