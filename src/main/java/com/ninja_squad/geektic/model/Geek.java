package com.ninja_squad.geektic.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Geek {
	@Id
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String sexe;
	private String description;
	private String photo;
	@ManyToMany
	@JoinTable(name="AVOIR", 
			joinColumns = @JoinColumn(name = "ID_GEEK"),                
			inverseJoinColumns = @JoinColumn(name = "ID_INTERET"))
	private Set<Interet> lesInterets;
	
	//CONSTRUCTOR
	public Geek(int id, String nom, String prenom, String mail, String sexe, String description, String photo) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.sexe = sexe;
		this.description = description;
	}
	
	//GETTER AND SETTER
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
