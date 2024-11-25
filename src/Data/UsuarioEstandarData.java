/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Domain.Articulo;
import Domain.UsuarioEstandar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kevin
 */
public class UsuarioEstandarData {

    private String rutaArchivo;

    public UsuarioEstandarData(String rutaArchivo)
    {
        this.rutaArchivo = rutaArchivo;
    }

    public boolean actualizarUsuario(UsuarioEstandar usuario) throws FileNotFoundException, IOException {

        File file = new File(rutaArchivo);
        File tempFile = new File("archivoAdminTemp.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, false));

        String linea = br.readLine();
        while (linea != null) {
            String datos[] = linea.split(";");
            if (usuario.getIdentificacion()!=Integer.parseInt(datos[1])) {
                bw.write(linea);
                bw.newLine();
            } else {
                bw.write(usuario.getSaldo() + ";" + usuario.getIdentificacion() + ";" + usuario.getNombre() + ";" + usuario.getContrasenna());

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

}
