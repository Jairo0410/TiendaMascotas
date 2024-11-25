package Data;

import Domain.Articulo;
import Domain.UsuarioEstandar;
import Utility.ConstanteArchivos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class InventarioUsuarioData {

    private String rutaArchivo;

    public InventarioUsuarioData(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public boolean guardarArticulo(Articulo articulo, UsuarioEstandar usuario, int cantComprada) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true));

        bw.write(articulo.getId() + ";" + usuario.getIdentificacion() + ";" + cantComprada);
        bw.newLine();
        bw.flush();
        
        bw.close();

        return true;

    }

    public ArrayList<Articulo> obtenerInventario(int idUsuario) throws IOException {

        InventarioTiendaData invTiendaData = new InventarioTiendaData(ConstanteArchivos.RUTA_INVENTARIO_TIENDA);

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        ArrayList<Articulo> articulos = new ArrayList<>();

        String linea = br.readLine();

        while (linea != null) {
            String datos[] = linea.split(";");

            linea = br.readLine();
            if (Integer.parseInt(datos[1]) == idUsuario) {
                Articulo articulo = invTiendaData.obtenerArticulo(Integer.parseInt(datos[0]));
                articulo.setCantExistente(Integer.parseInt(datos[2]));
                articulos.add(articulo);

            }

        }

        br.close();

        return articulos;

    }

    public boolean actualizarArticulo(Articulo articulo, UsuarioEstandar usuario) throws FileNotFoundException, IOException {

        File file = new File(rutaArchivo);
        File tempFile = new File("articuloUsuarioTemp.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, false));

        String linea = br.readLine();
        while (linea != null) {
            String datos[] = linea.split(";");
            if (articulo.getId() == Integer.parseInt(datos[0]) && usuario.getNombre().equals(datos[1])) {
                bw.write(linea);
                bw.newLine();
            } else {
                bw.write(articulo.getId() + ";" + usuario.getNombre() + ";" + articulo.getCantExistente());

                bw.newLine();
            }
            linea = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();

        if (file.delete() && tempFile.renameTo(file)) {
            return true;
        }
        return false;
    }

    public Articulo obtenerArticulo(int idUsuario, int idArticulo) throws IOException {
        InventarioTiendaData inventarioData = new InventarioTiendaData(ConstanteArchivos.RUTA_INVENTARIO_TIENDA);

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

        String linea = br.readLine();

        while (linea != null) {
            String datos[] = linea.split(";");
            if (Integer.parseInt(datos[0]) == idArticulo && Integer.parseInt(datos[1]) == idUsuario) {

                Articulo articulo = inventarioData.obtenerArticulo(idArticulo);
                br.close();
                return articulo;
            }
            linea = br.readLine();
        }

        br.close();

        return null;

    }

    public boolean existeArchivo() {
        File file = new File(rutaArchivo);

        return file.exists();

    }

}
