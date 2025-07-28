package fol1.fol2.entities;


import java.io.Serializable;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="notification")
public class Notification implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 @ManyToOne
	    @JoinColumn(name = "reservation_code") // Colonne de clé étrangère pour Filiere
	    private Reservation reservation;
	private String libelle;
	public Notification(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	
	
	
	public Notification(Reservation reservation, String libelle) {
		super();
		this.reservation = reservation;
		this.libelle = libelle;
	}




	public Notification(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}



	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reservation getReservation() {
		return reservation;
	}



	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	
	

  
   
}


