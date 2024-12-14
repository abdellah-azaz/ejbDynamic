package fol1.fol2.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
//ce projet est ...

@Entity
@Table(name="categorie")
public class Categorie implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	private String libelle;
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

  
   
}

