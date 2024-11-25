/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.InventarioTiendaData;
import Domain.Articulo;
import Utility.ConstanteArchivos;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class InventarioTiendaBusiness {

    private InventarioTiendaData inventarioTiendaData;

    public InventarioTiendaBusiness() {
        this.inventarioTiendaData = new InventarioTiendaData(ConstanteArchivos.RUTA_INVENTARIO_TIENDA);
    }

    public boolean guardarArticulo(Articulo articulos) throws IOException {
        return this.inventarioTiendaData.guardarArticulo(articulos);
    }

    public ArrayList<Articulo> obtenerInventario() throws IOException {
        return this.inventarioTiendaData.obtenerInventario();
    }

    public boolean actualizarArticulo(Articulo articulos) throws IOException {
        return this.inventarioTiendaData.actualizarArticulo(articulos);
    }

    public void guardarInvInicial() throws IOException {
        this.inventarioTiendaData.guardarInvInicial();
    }

    public Articulo obtenerArticulo(int idArticulo) throws IOException {
        return this.inventarioTiendaData.obtenerArticulo(idArticulo);
    }


}
