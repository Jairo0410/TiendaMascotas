/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class Compra {

    private Articulo articulos;
    private UsuarioEstandar usuario;
    private int cantComprada;

    public Compra(Articulo articulos, UsuarioEstandar usuario, int cantComprada) {
        this.articulos = articulos;
        this.usuario = usuario;
        this.cantComprada = cantComprada;
    }

    public Articulo getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulo articulos) {
        this.articulos = articulos;
    }

    public UsuarioEstandar getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEstandar usuario) {
        this.usuario = usuario;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }
    
    
    
    
    
}
