package Domain;

/**
 *
 * @author Kevin
 */
public class Truco {
    
    private String nombre;
    private int experienciaMinima;
    private int experienciaRecompensa;
    private int puntosRecompesa;

    public Truco(String nombre, int experienciaMinima, int puntosRecompesa,int experienciaRecompensa) {
        this.nombre = nombre;
        this.experienciaMinima = experienciaMinima;
        this.experienciaRecompensa=experienciaRecompensa;
        this.puntosRecompesa = puntosRecompesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExperienciaMinima() {
        return experienciaMinima;
    }

    public void setExperienciaMinima(int experienciaMinima) {
        this.experienciaMinima = experienciaMinima;
    }

    public int getExperienciaRecompensa() {
        return experienciaRecompensa;
    }

    public void setExperienciaRecompensa(int experienciaRecompensa) {
        this.experienciaRecompensa = experienciaRecompensa;
    }
    
    public int getPuntosRecompesa() {
        return puntosRecompesa;
    }

    public void setPuntosRecompesa(int puntosRecompesa) {
        this.puntosRecompesa = puntosRecompesa;
    }    
}
