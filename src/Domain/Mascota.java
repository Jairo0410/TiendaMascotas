/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author Kevin
 */
public class Mascota {

    private String nombre;
    private String descripcion;
    private int edad;
    private float vida;
    private float nivelDiversion;
    private float experiencia;
    private String tipo;
    private int idUsuario;

    public Mascota(String nombre, String descripcion, int edad, float vida, float nivelDiversion, float experiencia, String tipo, int idUsuario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edad = edad;
        this.vida = vida;
        this.nivelDiversion = nivelDiversion;
        this.experiencia = experiencia;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
    }

    public Mascota(String nombre, String descripcion, int edad, String tipo, int idUsuario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edad = edad;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.vida = 100;
        this.nivelDiversion = 100;
        this.experiencia = 0;
    }

    public Mascota() {
        this.nombre = null;
        this.descripcion = null;
        this.edad = 0;
        this.tipo = null;
        this.idUsuario = 0;
        this.vida = 0;
        this.nivelDiversion = 0;
        this.experiencia = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public float getNivelDiversion() {
        return nivelDiversion;
    }

    public void setNivelDiversion(float nivelDiversion) {
        this.nivelDiversion = nivelDiversion;
    }

    public float getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(float experiencia) {
        this.experiencia = experiencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPrecio() {

        return 0;
    }

    public void acumularPuntos() {

    }

    public void aprenderTruco(Truco truco) 
    {
        float experienciaAdquirida = 0;
        
        experienciaAdquirida = experiencia + truco.getExperienciaRecompensa();

    }

}
