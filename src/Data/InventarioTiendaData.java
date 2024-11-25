package Data;

import Domain.Alimento;
import Domain.Articulo;
import Domain.Higiene;
import Domain.InventarioTienda;
import Domain.Juguete;
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
    
    public boolean guardarArticulo(Articulo articulo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true));

        bw.write(articulo.representacionArchivo());
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
            
            // TODO: Arreglar esto despues
            int id = Integer.parseInt(datos[0]);
            String tipo = datos[1];
            String nombre = datos[2];
            int precio = Integer.parseInt(datos[3]);
            int cantidad = Integer.parseInt(datos[4]);
            
            Articulo articulo;
            
            if (tipo.equals("Higiene")) {
                float duracionEfecto = Float.parseFloat(datos[5]);
                articulo = new Higiene(duracionEfecto, id, nombre, precio, cantidad);
            } else if (tipo.equals("Alimento")) {
                int valorNutricional = Integer.parseInt(datos[5]);
                articulo = new Alimento(valorNutricional, id, nombre, precio, cantidad);
            } else {
                float nivelDiversion = Float.parseFloat(datos[5]);
                articulo = new Juguete(nivelDiversion, id, nombre, precio, cantidad);
            }
            
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
                bw.write(articulos.representacionArchivo());
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
            
            // TODO: Arreglar esto despues
            int id = Integer.parseInt(datos[0]);
            String tipo = datos[1];
            String nombre = datos[2];
            int precio = Integer.parseInt(datos[3]);
            int cantidad = Integer.parseInt(datos[4]);
            
            Articulo articulo;
            
            if (tipo.equals("Higiene")) {
                float duracionEfecto = Float.parseFloat(datos[5]);
                articulo = new Higiene(duracionEfecto, id, nombre, precio, cantidad);
            } else if (tipo.equals("Alimento")) {
                int valorNutricional = Integer.parseInt(datos[5]);
                articulo = new Alimento(valorNutricional, id, nombre, precio, cantidad);
            } else {
                float nivelDiversion = Float.parseFloat(datos[5]);
                articulo = new Juguete(nivelDiversion, id, nombre, precio, cantidad);
            }
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
