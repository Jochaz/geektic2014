package com.ninja_squad.geektic.dao;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.model.Geek;

public class GeekDaoTest extends com.ninja_squad.geektic.dao.BaseDaoTest {
    @Autowired
    private GeekDao geekDao;

    @Before
    public void populateDatabase() {
        Operation operation =
                sequenceOf(
                        CommonOperations.DELETE_ALL,
                        CommonOperations.INSERT_DATA);

        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }
    
    @Test
    public void testFindById() throws Exception {
        int expected = 1;
        int response = geekDao.findById(expected).getId();
        assertEquals(expected, response);
    }
    
    @Test
    public void testinterets() throws Exception {
        int response = geekDao.interets().size();
        assertEquals(6, response);
    }
    
    @Test
    public void testFindBySexAndInterest() {
        List<Integer> expected = Arrays.asList(3);
        
        List<Integer> response = geekDao.findBySexeAndInterest("H", 1).stream().map(Geek::getId).collect(Collectors.toList());
        Collections.sort(response);

        assertEquals(expected, response);
    }
    
    @Test
    public void testFindAll() {
    	int count = 6;
    	int countDao = geekDao.findAll().size();
    	assertEquals(count, countDao);
    }
    

}
