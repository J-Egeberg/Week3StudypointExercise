/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Pet;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Oakberg
 */
public interface PetHospitalFacade {
    
      public void addEntityManagerFactory(EntityManagerFactory emf);
  public Pet addPet(Pet p);  
  public Pet deletePet(int id);  
  public Pet getPet(int id);  
  public List<Pet> findAll();  
  public Pet editPer(Pet p);  
  public long getPetCount();

    
}
