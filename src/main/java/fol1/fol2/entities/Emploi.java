package fol1.fol2.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "emploi")
public class Emploi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Clé primaire pour l'entité Charge

   

    @ManyToOne
    @JoinColumn(name = "filiere_code") // Colonne de clé étrangère pour Filiere
    private Filiere filiere;



	public Emploi() {
	}



	public Emploi(Filiere filiere) {
		super();
		this.filiere = filiere;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Filiere getFiliere() {
		return filiere;
	}



	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
    
   

 
}



