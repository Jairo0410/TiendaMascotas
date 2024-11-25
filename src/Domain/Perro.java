/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author Kevin
 */
public class Perro extends Mascota {

    public Perro(String nombre, String descripcion, int edad, String tipo, int idUsuario) {
        super(nombre, descripcion, edad, "Perro", idUsuario);
    }

    public Perro(String nombre, String descripcion, int edad, float vida, float nivelDiversion, float experiencia, String tipo, int idUsuario) {
        super(nombre, descripcion, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
    }

    public Perro() {
        super();
    }
    
    

    @Override
    public  int getPrecio() {
        int precio = 2000;
        return precio;
    }

    @Override
    public String representacionArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
