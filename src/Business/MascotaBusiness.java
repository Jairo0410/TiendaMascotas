/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.MascotaData;
import Domain.Mascota;
import Utility.ConstanteArchivos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class MascotaBusiness {

    private MascotaData mascotaData;

    public MascotaBusiness() {
        this.mascotaData = new MascotaData(ConstanteArchivos.RUTA_MASCOTAS);
    }

    public boolean registrarMascota(Mascota mascota) throws FileNotFoundException, IOException {
        return this.mascotaData.registrarMascota(mascota);
    }

    public ArrayList<Mascota> leer() throws FileNotFoundException, IOException {
        return this.mascotaData.leer();
    }

    public void actualizarMascota(Mascota mascota) throws FileNotFoundException, IOException {
        this.mascotaData.actualizarMascota(mascota);
    }

    public Mascota buscarMascota(String nombre) throws FileNotFoundException, IOException {
        return mascotaData.buscarMascota(nombre);
    }

    public ArrayList<Mascota> obtenerMascotasUsuario(int identificacion) throws FileNotFoundException, IOException {
        return this.mascotaData.obtenerMascotasUsuario(identificacion);
    }

}
