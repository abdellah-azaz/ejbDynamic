package fol1.fol2.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="notification_prof")
public class NotificationProf implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	
	public NotificationProf(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	
	
	public NotificationProf(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}



	public NotificationProf() {
		super();
		// TODO Auto-generated constructor stub
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


