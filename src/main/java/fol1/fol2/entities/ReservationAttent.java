package fol1.fol2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "reservation_attent")
public class ReservationAttent implements Serializable{

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id; // Clé primaire pour l'entité Charge

	   

	    @ManyToOne
	    @JoinColumn(name = "filiere_code") // Colonne de clé étrangère pour Filiere
	    private Filiere filiere;

	    
	    @ManyToOne
	    @JoinColumn(name = "user_code") // Colonne de clé étrangère pour Filiere
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "salle_code") // Colonne de clé étrangère pour Filiere
	    private Salle salle; 

		public ReservationAttent(Filiere filiere, User user, Salle salle) {
			super();
			this.filiere = filiere;
			
			this.user = user;
			this.salle = salle;
		}
		
		

		public ReservationAttent() {
			super();
			// TODO Auto-generated constructor stub
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

