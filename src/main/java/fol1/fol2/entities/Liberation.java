package fol1.fol2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "liberation")
public class Liberation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Clé primaire pour l'entité Charge

   

    @ManyToOne
    @JoinColumn(name = "reservation_code") // Colonne de clé étrangère pour Filiere
    private Reservation reservation;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEtHeure;

	public Liberation(Reservation reservation, Date dateEtHeure) {
		super();
		this.reservation = reservation;
		this.dateEtHeure = dateEtHeure;
	}

	public Liberation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Date getDateEtHeure() {
		return dateEtHeure;
	}

	public void setDateEtHeure(Date dateEtHeure) {
		this.dateEtHeure = dateEtHeure;
	} 

   

	
    
    
    
   

 
}




