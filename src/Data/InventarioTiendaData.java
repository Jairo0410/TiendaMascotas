package Data;

import Domain.Articulo;
import Domain.InventarioTienda;
import Utility.ArticulosConstante;
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
public class InventarioTiendaData {

    private String rutaArchivo;

    public InventarioTiendaData(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public boolean guardarArticulo(Articulo articulos) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true));

        bw.write(articulos.getId() + ";" + articulos.getNombre() + ";" + articulos.getPrecio() + ";" + articulos.getCantExistente());
        bw.newLine();
        bw.flush();
        
        bw.close();

        return true;
    }

    public ArrayList<Articulo> obtenerInventario() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        ArrayList<Articulo> articulos = new ArrayList<>();

        String linea = br.readLine();

        while (linea != null) {
            String datos[] = linea.split(";");
            Articulo articulo = new Articulo(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
            linea = br.readLine();
            articulos.add(articulo);
        }

        br.close();

        return articulos;

    }

    public boolean actualizarArticulo(Articulo articulos) throws FileNotFoundException, IOException {

        File file = new File(rutaArchivo);
        File tempFile = new File("articuloTiendaTemp.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, false));

        String linea = br.readLine();
        while (linea != null) {
            String datos[] = linea.split(";");
            if (articulos.getId() != Integer.parseInt(datos[0])) {
                bw.write(linea);
                bw.newLine();
            } else {
                bw.write(articulos.getId() + ";" + articulos.getNombre() + ";" + articulos.getPrecio() + ";" + articulos.getCantExistente());
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

    public void guardarInvInicial() throws IOException {
        InventarioTienda inventario = ArticulosConstante.obtenerInventarioInicial();

        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            for (Articulo articulo : inventario.getArticulos()) {
                guardarArticulo(articulo);
            }

        }

    }

    public Articulo obtenerArticulo(int idArticulo) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

        String linea = br.readLine();

        while (linea != null) {
            String datos[] = linea.split(";");
            Articulo articulo = new Articulo(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
            linea = br.readLine();

            if (articulo.getId() == idArticulo) {
                br.close();
                return articulo;

            }
        }

        br.close();

        return null;

    }

}
