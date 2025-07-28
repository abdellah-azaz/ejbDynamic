package fol1.fol2.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="filiere")
public class Filiere implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	private int effectif;
	private String libelle;
	public Filiere(int effectif, String libelle) {
		super();
		this.effectif = effectif;
		this.libelle = libelle;
	}
	
	
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getEffectif() {
		return effectif;
	}
	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

  
   
}

