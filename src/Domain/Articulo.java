/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author Kevin
 */
public class Articulo {

    private int id;
    private String nombre;
    private int precio;
    private int cantExistente;
  
    public Articulo(int id, String nombre, int precio,int cantExistente)
    {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantExistente=cantExistente;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantExistente() {
        return cantExistente;
    }

    public void setCantExistente(int cantExistente) {
        this.cantExistente = cantExistente;
    }

    public void efectoArticulo(Mascota mascota)
    {

    }

}
