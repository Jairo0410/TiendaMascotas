package Data;

import Domain.Ave;
import Domain.Gato;
import Domain.Mascota;
import Domain.Perro;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class MascotaData {

    private String rutaArchivo;

    public MascotaData(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public boolean registrarMascota(Mascota mascota) throws FileNotFoundException, IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("mascotas.bin", true));

        dos.writeUTF(mascota.getNombre());
        dos.writeUTF(mascota.getDescripcion());
        dos.writeInt(mascota.getEdad());
        dos.writeFloat(mascota.getVida());
        dos.writeFloat(mascota.getNivelDiversion());
        dos.writeFloat(mascota.getExperiencia());
        dos.writeUTF(mascota.getTipo());
        dos.writeInt(mascota.getIdUsuario());
        
        dos.close();

        return true;
    }

    public ArrayList<Mascota> leer() throws FileNotFoundException, IOException {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        DataInputStream dis = new DataInputStream(
                new FileInputStream("mascotas.bin")
        );

        while (dis.available() > 0) {

            String nombre = dis.readUTF();
            String description = dis.readUTF();
            int edad = dis.readInt();
            float vida = dis.readFloat();
            float nivelDiversion = dis.readFloat();
            float experiencia = dis.readFloat();
            String tipo = dis.readUTF();
            int idUsuario = dis.readInt();
            
            // TODO: Arreglar esto luego
            Mascota mascota;
            
            if (tipo.equals("Perro")) {
                mascota = new Perro(nombre, description, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
            } else if (tipo.equals("Gato")) {
                mascota = new Gato(nombre, description, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
            } else {
                mascota = new Ave(nombre, description, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
            }

            mascotas.add(mascota);
        }
        
        dis.close();

        return mascotas;
    }

    public void actualizarMascota(Mascota mascota) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(rutaArchivo, "rw");

        while (raf.getFilePointer() < raf.length()) {
            String nombre = raf.readUTF();
            if (nombre.equals(mascota.getNombre())) {
                // Sobreescribe
                raf.writeUTF(mascota.getDescripcion());
                raf.writeInt(mascota.getEdad());
                raf.writeFloat(mascota.getVida());
                raf.writeFloat(mascota.getNivelDiversion());
                raf.writeFloat(mascota.getExperiencia());
                raf.writeUTF(mascota.getTipo());
                raf.writeInt(mascota.getIdUsuario());
            }
        }

        raf.close();
    }

    public Mascota buscarMascota(String nombre) throws FileNotFoundException, IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(rutaArchivo));

        while (dis.available() > 0) {

            String nombreMascota = dis.readUTF();
            String description = dis.readUTF();
            int edad = dis.readInt();
            float vida = dis.readFloat();
            float nivelDiversion = dis.readFloat();
            float experiencia = dis.readFloat();
            String tipo = dis.readUTF();
            int idUsuario = dis.readInt();
            
            // TODO: Arreglar esto luego
            Mascota mascota;
            
            if (tipo.equals("Perro")) {
                mascota = new Perro(nombreMascota, description, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
            } else if (tipo.equals("Gato")) {
                mascota = new Gato(nombreMascota, description, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
            } else {
                mascota = new Ave(nombreMascota, description, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
            }

            if (mascota.getNombre().equals(nombre)) {

                return mascota;

            }

        }
        
        dis.close();
        return null;
    }

    public ArrayList<Mascota> obtenerMascotasUsuario(int identificacion) throws FileNotFoundException, IOException {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        DataInputStream dis = new DataInputStream(
                new FileInputStream("mascotas.bin")
        );

        while (dis.available() > 0) {

            String nombreMascota = dis.readUTF();
            String description = dis.readUTF();
            int edad = dis.readInt();
            float vida = dis.readFloat();
            float nivelDiversion = dis.readFloat();
            float experiencia = dis.readFloat();
            String tipo = dis.readUTF();
            int idUsuario = dis.readInt();
            
            // TODO: Arreglar esto luego
            Mascota mascota;
            
            if (tipo.equals("Perro")) {
                mascota = new Perro(nombreMascota, description, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
            } else if (tipo.equals("Gato")) {
                mascota = new Gato(nombreMascota, description, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
            } else {
                mascota = new Ave(nombreMascota, description, edad, vida, nivelDiversion, experiencia, tipo, idUsuario);
            }

            if (mascota.getIdUsuario() == identificacion) {
                mascotas.add(mascota);
            }
        }
        
        dis.close();

        return mascotas;
    }

}
