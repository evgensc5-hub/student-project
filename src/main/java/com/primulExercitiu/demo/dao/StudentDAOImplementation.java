package com.primulExercitiu.demo.dao;

import com.primulExercitiu.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
    @Override
    public List<Student> findAll() {
        //Creare query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ", Student.class);

        //returnam query results
        return theQuery.getResultList();
    }
    @Override
    public List<Student> findByLastName(String theLastName){

        //Creare Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //setarea parametrilor pentru Query
        theQuery.setParameter("theData", theLastName);

        //returneaza rezultatelor Query
        return theQuery.getResultList();
    }
    @Transactional
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }
    @Override
    @Transactional
    public void delete(Integer id) {

        //preluam studentul din baza de date
        Student theStudent = entityManager.find(Student.class, id);

        //sterge studentul
        entityManager.remove(theStudent);
    }
    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student ").executeUpdate();
        return numRowsDeleted;
    }

}
