package com.ninja_squad.geektic.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ninja_squad.geektic.model.Geek;

public class GeekDao {
	private EntityManager em;
	//Retourne la liste des geeks en fonction du sexe et du centre d'interet saisie
	public List<Geek> findByInterestAndSex(String sexe, int interet){
		String jpql = "SELECT g"
				+ " FROM Geek g "
				+ "JOIN g.lesInterets i "
				+ "WHERE g.sexe = :sexe "
				+ "AND i.id = :interet";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter(sexe, interet);
		return query.getResultList();		
	}
	
	//Retourne un geek en fonction de son id (pour l'affichage du profil)
	public Geek findAGeekById(int id){
		return em.find(Geek.class, id);
	}
}
