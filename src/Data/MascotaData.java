package Data;

import Domain.Mascota;
import Domain.UsuarioEstandar;
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

            Mascota mascota = new Mascota(
                    dis.readUTF(),
                    dis.readUTF(),
                    dis.readInt(),
                    dis.readFloat(),
                    dis.readFloat(),
                    dis.readFloat(),
                    dis.readUTF(),
                    dis.readInt()
            );

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

            Mascota mascota = new Mascota(
                    dis.readUTF(),
                    dis.readUTF(),
                    dis.readInt(),
                    dis.readFloat(),
                    dis.readFloat(),
                    dis.readFloat(),
                    dis.readUTF(),
                    dis.readInt()
            );

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

            Mascota mascota = new Mascota(
                    dis.readUTF(),
                    dis.readUTF(),
                    dis.readInt(),
                    dis.readFloat(),
                    dis.readFloat(),
                    dis.readFloat(),
                    dis.readUTF(),
                    dis.readInt()
            );

            if (mascota.getIdUsuario() == identificacion) {
                mascotas.add(mascota);
            }
        }
        
        dis.close();

        return mascotas;
    }

}
