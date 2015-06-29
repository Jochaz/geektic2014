package com.ninja_squad.geektic.service;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.model.Interet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Fake service just to test that everything works fine
 * @author JB Nizet
 */
@RestController
@Transactional
@RequestMapping("api/interets")
public class InteretService {



    @Autowired
    private GeekDao dao;

    //Appel du DAO pour la recuperation de la liste des interets
    @RequestMapping(method = GET)
    public List<Interet> lesInterets() {

        return dao.interets();
    }

}