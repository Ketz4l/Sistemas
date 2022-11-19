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

import com.ejemplos.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("productos")
public class ProductosServicio {
    @GET //Muestra la lista de productos
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductos(){
        List<Producto> lista = new ArrayList();
        
        //id, nombre, precio, cantidad
        Producto a = new Producto(1, "Aceite", 10, 2);
        Producto b = new Producto(2, "Harina", 20, 12);
        Producto c = new Producto(3, "Pasta", 100, 5);
        lista.add(a);
        lista.add(b);
        lista.add(c);
        return Response.ok(lista).build();
    }
    
    
}
