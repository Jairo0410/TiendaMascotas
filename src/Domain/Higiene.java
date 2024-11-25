package Domain;

/**
 *
 * @author Kevin
 */
public class Higiene extends Articulo{
    
    private float duracionEfecto;

    public Higiene(float duracionEfecto, int id, String nombre, int precio, int cantExistente) {
        super(id, nombre, precio, cantExistente);
        this.duracionEfecto = duracionEfecto;
    }

    public float getDuracionEfecto() {
        return duracionEfecto;
    }

    public void setDuracionEfecto(float duracionEfecto) {
        this.duracionEfecto = duracionEfecto;
    }

    
    
    
    
}
