package Domain;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class Higiene extends Articulo{
    
    private float duracionEfecto;

    public Higiene(float duracionEfecto, int id, String nombre, int precio, int cantExistente) {
        super(id, nombre, precio, cantExistente, "Higiene");
        this.duracionEfecto = duracionEfecto;
    }

    public float getDuracionEfecto() {
        return duracionEfecto;
    }

    public void setDuracionEfecto(float duracionEfecto) {
        this.duracionEfecto = duracionEfecto;
    }

    @Override
    public void efectoArticulo(Mascota mascota) {
        mascota.setUltimaInteracion(Date.from(Instant.now()));
    }

    @Override
    public String representacionArchivo() {
        return this.getId() + ";" + this.getTipo() + ";" + this.getNombre() + ";" + this.getPrecio() + ";" + this.getCantExistente() + ";" + this.getDuracionEfecto();
    }

    @Override
    public String getEfecto() {
        return "+" + this.duracionEfecto + " limpieza";
    }
    
}
