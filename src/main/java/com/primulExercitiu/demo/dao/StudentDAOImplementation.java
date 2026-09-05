package com.primulExercitiu.demo.dao;

import com.primulExercitiu.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImplementation implements StudentDAO {

    //cinp pentru EntityManager(va fi utilizat pentru interactiunea cu baza de date)
    private EntityManager entityManager;

    //injectare EntityManager prin construcctor (practica recomandata pentru testabilitate si modularitate)
    @Autowired
    public StudentDAOImplementation (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //importarea metodei save pentru salvarea unui obiect Student in baza de date
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

}
