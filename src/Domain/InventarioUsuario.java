package Domain;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class InventarioUsuario
{
    private ArrayList<Articulo>articulos;
    private UsuarioEstandar usuario;

    public InventarioUsuario(ArrayList<Articulo> articulos, UsuarioEstandar usuario) {
        this.articulos = articulos;
        this.usuario = usuario;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public UsuarioEstandar getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEstandar usuario) {
        this.usuario = usuario;
    }
    
    
    
}
