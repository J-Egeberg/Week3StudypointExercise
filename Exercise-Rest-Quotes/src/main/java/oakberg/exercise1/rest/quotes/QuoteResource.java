/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oakberg.exercise1.rest.quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jsonmappers.Quote;

/**
 * REST Web Service
 *
 * @author Oakberg
 */
@Path("quote")
public class QuoteResource {

    @Context
    private UriInfo context;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Quote quote = new Quote(4, "Fire to the rain");
    private static int nextId;
    
    private static Map<Integer,String> quotes = new HashMap() {
  {
   put(1, "Friends are kisses blown to us by angels");
   put(2, "Do not take life too seriously. You will never get out of it alive");
   put(3, "Behind every great man, is a woman rolling her eyes");
   }
};

    
    /**
     * Creates a new instance of QuoteResource
     */
    public QuoteResource() {
    }

    /**
     * Retrieves representation of an instance of oakberg.exercise1.rest.quotes.QuoteResource
     * @return an instance of java.lang.String
     */    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") int id){
        String specificQuote = quotes.get(id);
        return id+" : "+gson.toJson(specificQuote);
    }
    
    @GET
    @Path("random")
    public String getRandom() {
        Random random    = new Random();
        int i = random.nextInt(quotes.size());
        String randomQuote = quotes.get(i);
        
        return gson.toJson(randomQuote);
    }
    
    @GET
    @Path("all")
    public String getAll() {
        return gson.toJson(quotes.values());
    }
    

    /**
     * PUT method for updating or creating an instance of QuoteResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addQuote(String quoteAsJson) {
        Quote quote = gson.fromJson(quoteAsJson, Quote.class);
        quote.setId(nextId);

        quotes.put(nextId, quote.getName());
        nextId++;
        return gson.toJson(quote);
        
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String changeQuote (@PathParam("id") int id, String quoteAsJson) {
        Quote quote = gson.fromJson(quoteAsJson, Quote.class);
        quotes.put(quote.getId(), quote.getName());
        return gson.toJson(quote);
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteJson(@PathParam("id") int id){
    return gson.toJson(quotes.remove(id));    
    }
}
