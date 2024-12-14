package fol1.fol2.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User implements Serializable {
//javax.persistence.schema-generation.database.action
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	private String nom;
	private String prenom;
	private String telephon;
	private String mot_de_passe;
	private String statut;
	private String email;
	private String role;
	public User(String nom, String prenom, String telephon, String mot_de_passe, String statut,String email,String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephon = telephon;
		this.mot_de_passe = mot_de_passe;
		this.statut = statut;
		this.email=email;
		this.role=role;
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephon() {
		return telephon;
	}
	public void setTelephon(String telephon) {
		this.telephon = telephon;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	

  
   
}

