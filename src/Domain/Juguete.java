package Domain;

/**
 *
 * @author Kevin
 */
public class Juguete extends Articulo {

    private float nivelDiversion;

    public Juguete(float nivelDiversion, int id, String nombre, int precio, int cantExistente) {
        super(id, nombre, precio, cantExistente);
        this.nivelDiversion = nivelDiversion;
    }

    public float getNivelDiversion() {
        return nivelDiversion;
    }

    public void setNivelDiversion(float nivelDiversion) {
        this.nivelDiversion = nivelDiversion;
    }

    @Override
    public void efectoArticulo(Mascota mascota) 
    {
        float aumentoDiversion = mascota.getNivelDiversion()+ nivelDiversion;
        mascota.setNivelDiversion(aumentoDiversion);
    }

}