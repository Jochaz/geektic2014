package com.ninja_squad.geektic.dao;

        import com.ninja_squad.geektic.model.Geek;
        import com.ninja_squad.geektic.model.Interet;
        import org.springframework.stereotype.Repository;import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import javax.persistence.TypedQuery;
        import java.util.List;/**
 * Created by phil on 22/06/15.
 */
@Repository
public class GeekDao {
    @PersistenceContext
    private EntityManager entityManager;


    //Requete de recherche par sexe et interet
    public List<Geek> findBySexeAndInterest(String sexe, int interet){
        String reqSexeInteret = "SELECT g FROM Geek g JOIN g.lesInterets i WHERE g.sexe = :sexe AND i.id = :interet ORDER BY g.nom";
        TypedQuery<Geek> resultReq = entityManager.createQuery(reqSexeInteret, Geek.class); resultReq.setParameter("sexe", sexe).setParameter("interet", interet);
        return resultReq.getResultList();
    }

    //Requete qui recupere un geek
    //Plus utilisé mais testé
    public Geek findById(int id) {
        String reqUtilisateur = "SELECT g FROM Geek g WHERE g.id = :id ORDER BY g.nom";
        TypedQuery<Geek> resultReq = entityManager.createQuery(reqUtilisateur, Geek.class).setParameter("id", id);
        return resultReq.getResultList().get(0);
    }

    //Retourne la list des interets
    public List<Interet> interets() {
        String reqInterets = "SELECT i FROM Interet i";
        TypedQuery<Interet> resultReq = entityManager.createQuery(reqInterets, Interet.class);
        return resultReq.getResultList();
    }

    //Retourne tout les geeks
	public List<Geek> findAll() {
		String reqAll = "SELECT g FROM Geek g";
		TypedQuery<Geek> resultAll = entityManager.createQuery(reqAll, Geek.class);
		return resultAll.getResultList();
	}
	
}