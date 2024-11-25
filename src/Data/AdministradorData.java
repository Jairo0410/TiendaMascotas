package Data;

import Domain.Usuario;
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
public class AdministradorData {

    private String rutaArchivo;

    public AdministradorData(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public boolean guardarUsuario(UsuarioEstandar estandar) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true));

        bw.write(estandar.getSaldo() + ";" + estandar.getIdentificacion() + ";" + estandar.getNombre() + ";" + estandar.getContrasenna());
        bw.newLine();
        bw.flush();
        
        bw.close();
        return true;
    }


    public boolean eliminarUsuario(int identificacion) throws FileNotFoundException, IOException {
        File file = new File(rutaArchivo);
        File tempFile = new File("usuarioTemp.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, true));

        String linea = br.readLine();
        while (linea != null) {
            String datos[] = linea.split(";");
            if (identificacion != Integer.parseInt(datos[1])) {
                bw.write(linea);
                bw.newLine();
            }
            linea = br.readLine();
        } // while

        bw.flush();
        bw.close();
        br.close();

        if (file.delete() && tempFile.renameTo(file)) {
            return true;
        }
        return false;
    }

    public Usuario inicioSesion(int identificacion, String contrasenna) throws FileNotFoundException, IOException {
        File file = new File(rutaArchivo);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String linea = br.readLine();
        while (linea != null) {
            String datos[] = linea.split(";");
            
            System.out.println(datos[1]+" "+datos[3]);
            if (identificacion == Integer.parseInt(datos[1]) && contrasenna.equals(datos[3])) {
                UsuarioEstandar usuario = new UsuarioEstandar(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2], datos[3]);
                System.out.println("Si esta");
                
                br.close();
                return usuario;
            }
            linea = br.readLine();
        } 
        br.close();

        return null;
    }
    
    
    
}
