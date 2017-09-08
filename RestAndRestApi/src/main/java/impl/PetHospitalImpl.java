/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import entity.Pet;
import facade.PetHospitalFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Oakberg
 */
public class PetHospitalImpl implements PetHospitalFacade{

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pet addPet(Pet p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pet deletePet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

@Override
    public Pet getPet(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apiPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Pet p = em.find(Pet.class, id);
        em.getTransaction().commit();
        em.close();

        return p;
    }

    @Override
    public List<Pet> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apiPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Person.findAll");
        List<Pet> p = (List<Pet>) query.getResultList();

        em.getTransaction().commit();
        em.close();
        return p;

    }

    @Override
    public Pet editPer(Pet p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public long getPetCount() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apiPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT p FROM Pet p");
        em.getTransaction().commit();
        Long resultNumber = (Long) q.getSingleResult();
        em.close();
        return resultNumber;    }    
}
    

