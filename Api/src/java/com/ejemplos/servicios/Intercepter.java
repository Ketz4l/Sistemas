/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplos.servicios;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author damar
 */
//Cualquier consulta al api primero se ejecute esrto
@Provider
@PreMatching
public class Intercepter implements ContainerRequestFilter{
    public void filter(ContainerRequestContext request) throws IOException{
        String url = request.getUriInfo().getAbsolutePath().toString();
        
        if(url.contains(("/api/auth")))//dejar que pase
            return;
        
        String token = request.getHeaderString("Authorization");//se guarda en token
        
        if(token == null){
            //Le devolvemos json diciendo que esta mal
            JsonObject json = Json.createObjectBuilder().add("mensaje", "las credenciales son necesarias").build();
            
            //Aqui se vera si el token es diferente del que debería ser
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json)
                    .type(MediaType.APPLICATION_JSON).build());
            
            return;
        }
        
        if(!token.equals("AHGC-12BD-1328-75HF-HD64")){
            //Le devolvemos json diciendo que esta mal
            JsonObject json = Json.createObjectBuilder().add("mensaje", "credenciales incorrectas").build();
            
            //Aqui se vera si el token es diferente del que debería ser
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json)
                    .type(MediaType.APPLICATION_JSON).build());
            
            return;
        }
    }
}
