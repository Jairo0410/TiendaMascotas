/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import Domain.Usuario;

/**
 *
 * @author Kevin
 */
public class ManejoSesion {

    private static Usuario usuarioIniciado;

    public static void guardarSesion(Usuario usuario) {
        usuarioIniciado = usuario;
    }

    public static Usuario getUsuarioIniciado() {
        return usuarioIniciado;
    }


    public static void cerrarSesion()
    {
    usuarioIniciado=null;
    }

    
}
