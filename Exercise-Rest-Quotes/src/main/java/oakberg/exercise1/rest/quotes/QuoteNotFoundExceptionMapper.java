/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oakberg.exercise1.rest.quotes;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author Oakberg
 */
public class QuoteNotFoundExceptionMapper implements ExceptionMapper<QuoteNotFoundException> {

    @Override
    public Response toResponse(QuoteNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
}
