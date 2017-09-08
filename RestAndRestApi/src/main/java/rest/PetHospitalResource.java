/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Pet;
import impl.PetHospitalImpl;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Oakberg
 */
@Path("PetHospital")
public class PetHospitalResource {

    @Context
    private UriInfo context;
    
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Pet pet = new Pet();
    private static Map<Integer, Pet> pets = new HashMap();
    private PetHospitalImpl impl;


    /**
     * Creates a new instance of PetHospitalResource
     */
    public PetHospitalResource() {
    }

    /**
     * Retrieves representation of an instance of oakberg.restandrestapi.PetHospitalResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PetHospitalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @GET
    @Path("all")   
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getAll() {
    //return "hej";
    return gson.toJson(impl.findAll());
    }
    
    @GET
    @Path("count")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getCount(){
        return gson.toJson(impl.getPetCount());
    }
}
