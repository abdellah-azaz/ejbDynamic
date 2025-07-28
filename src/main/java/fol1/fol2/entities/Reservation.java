package fol1.fol2.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Clé primaire pour l'entité Charge

   

    public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
    @JoinColumn(name = "filiere_code") // Colonne de clé étrangère pour Filiere
    private Filiere filiere;

  
    
    @ManyToOne
    @JoinColumn(name = "user_code") // Colonne de clé étrangère pour Filiere
    private User user;

    @ManyToOne
    @JoinColumn(name = "salle_code") // Colonne de clé étrangère pour Filiere
    private Salle salle;

	public Reservation(Filiere filiere, User user, Salle salle) {
		super();
		this.filiere = filiere;
		
		this.user = user;
		this.salle = salle;
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

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
    
    
    
   

 
}




