/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplos.servicios;

/**
 *
 * @author damar
 */
import com.ejemplos.dao.UsuarioDAO;
import com.ejemplos.modelo.Usuario;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
public class LoginServicio {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    
    //Validar que el usuario manda datos correctos
    public Response validar(Usuario usuario){
        
        //Para validar el usuario
        boolean status = UsuarioDAO.validar(usuario.getUsername(), usuario.getPassword());
        if (status){
            String HASH = "AHGC-12BD-1328-75HF-HD64";
            
            JsonObject json = Json.createObjectBuilder().add("token", HASH).build();
            
            return Response.status(Response.Status.CREATED).entity(json).build();
        }
        //El usuario incorrecto
        JsonObject json = Json.createObjectBuilder().add("mensaje", "Datos incorrectos").build();
        
        return Response.status(Response.Status.UNAUTHORIZED).entity(json).build();
        
    }
}
