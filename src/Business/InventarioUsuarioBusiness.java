package Business;

import Data.InventarioUsuarioData;
import Domain.Articulo;
import Domain.Usuario;
import Domain.UsuarioEstandar;
import Utility.ConstanteArchivos;
import java.io.IOException;

/**
 *
 * @author Kevin
 */
public class InventarioUsuarioBusiness {

    private InventarioUsuarioData inventarioUData;

    public InventarioUsuarioBusiness() {
        this.inventarioUData = new InventarioUsuarioData(ConstanteArchivos.RUTA_INVENTARIO_USUARIO);
    }

    public void agregarInventario(UsuarioEstandar usuario, Articulo articulo, int cantComprada) throws IOException {
        Articulo articuloEncontrado = null;

        if (inventarioUData.existeArchivo()) {
            articuloEncontrado = inventarioUData.obtenerArticulo(usuario.getIdentificacion(), articulo.getId());
        }
        if (articuloEncontrado == null) {
            inventarioUData.guardarArticulo(articulo, usuario, cantComprada);
        } else {
            articulo.setCantExistente(articulo.getCantExistente() + cantComprada);
            inventarioUData.actualizarArticulo(articulo, usuario);
        }

    }

}
