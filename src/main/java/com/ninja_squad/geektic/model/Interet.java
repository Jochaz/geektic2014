package com.ninja_squad.geektic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Interet {
	@Id
	private int id;
	private String libelle;
	private String icone;
	
	//CONSTRUCTOR
	public Interet(){}
	public Interet(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	//GETTER AND SETTER
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

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}
	
	
	
}
