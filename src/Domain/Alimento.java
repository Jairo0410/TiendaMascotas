package Domain;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class Alimento extends Articulo {

    private int valorNutricional;

    public Alimento(int valorNutricional, int id, String nombre, int precio, int cantExistente) {
        super(id, nombre, precio, cantExistente, "Alimento");
        this.valorNutricional = valorNutricional;
    }

    public int getValorNutricional() {
        return valorNutricional;
    }

    public void setValorNutricional(int valorNutricional) {
        this.valorNutricional = valorNutricional;
    }

    
    @Override
    public void efectoArticulo(Mascota mascota) 
    {
        float aumentoVitalidad = mascota.getVida() + valorNutricional;
        mascota.setVida(aumentoVitalidad);
        mascota.setUltimaInteracion(Date.from(Instant.now()));
    }

    @Override
    public String representacionArchivo() {
        return this.getId() + ";" + this.getTipo() + ";" + this.getNombre() + ";" + this.getPrecio() + ";" + this.getCantExistente() + ";" + this.getValorNutricional();
    }

    @Override
    public String getEfecto() {
        return "+" + this.valorNutricional + " vida";
    }

}
