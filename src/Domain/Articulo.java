/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author Kevin
 */
public abstract class Articulo {

    private int id;
    private String nombre;
    private int precio;
    private int cantExistente;
    private String tipo;
  
    public Articulo(int id, String nombre, int precio,int cantExistente, String tipo)
    {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantExistente=cantExistente;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract void efectoArticulo(Mascota mascota);
    
    public abstract String representacionArchivo();
}
