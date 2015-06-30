package com.ninja_squad.geektic.service;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.model.Geek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Fake service just to test that everything works fine
 * @author JB Nizet
 */
@RestController
@Transactional
@RequestMapping("api/geeks")
public class GeekService {

    @Autowired
    private GeekDao dao;


    //Appel du DAO pour la recherche par sexe et interet grace au parametres de l'appel AJAX
    @RequestMapping(method = GET, params = {"sexe", "interet"})
    public List<Geek> lesGeek(@RequestParam("sexe") String sexe, @RequestParam("interet") int interet) {
        return dao.findBySexeAndInterest(sexe, interet);
    }

    //Appel du DAO pour la recherche d'un geek grace a l'id passé en parametres de l'appel AJAX
    @RequestMapping(method = GET, value="/{id}")
    public Geek leGeek(@PathVariable("id") int id, HttpServletRequest request) {
        return dao.findById(id);
    }
    
    @RequestMapping(method = GET)
    public List<Geek> tousLesGeek(){
		return dao.findAll();
    	
    }
    
}