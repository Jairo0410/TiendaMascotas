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

    public void agregarInventario(UsuarioEstandar usuario, Articulo articulo, int cantComprada) throws IOException, Exception {
        Articulo articuloEncontrado = null;

        if (usuario.getSaldo() < articulo.getPrecio() * cantComprada) {
            throw new Exception("El usuario no tiene suficiente saldo para realizar la compra");
        }
        
        if (inventarioUData.existeArchivo()) {
            articuloEncontrado = inventarioUData.obtenerArticulo(usuario.getIdentificacion(), articulo.getId());
        }
        if (articuloEncontrado == null) {
            inventarioUData.guardarArticulo(articulo, usuario, cantComprada);
        } else {
            articuloEncontrado.setCantExistente(articuloEncontrado.getCantExistente() + cantComprada);
            inventarioUData.actualizarArticulo(articuloEncontrado, usuario);
        }

    }

}
