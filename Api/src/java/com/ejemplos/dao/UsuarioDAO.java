/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplos.dao;

/**
 *
 * @author damar
 */

//Aquí les pasamos un username y el password

//validan si es igual al admin, si es correcto devuelve un valor boolesan
public class UsuarioDAO {
    public static boolean validar(String username, String password){
        return (username.equals("admin") && password.equals("admin"));
    }
}
