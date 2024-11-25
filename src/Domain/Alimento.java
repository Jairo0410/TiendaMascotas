package Domain;

/**
 *
 * @author Kevin
 */
public class Alimento extends Articulo {

    private int valorNutricional;

    public Alimento(int valorNutricional, int id, String nombre, int precio, int cantExistente) {
        super(id, nombre, precio, cantExistente);
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
    }

}
