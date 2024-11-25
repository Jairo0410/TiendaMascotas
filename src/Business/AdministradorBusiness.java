/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.AdministradorData;
import Domain.Usuario;
import Utility.ConstanteArchivos;
import java.io.IOException;

/**
 *
 * @author jairo
 */
public class AdministradorBusiness {
    private AdministradorData administradorData;
    
    public AdministradorBusiness() {
        this.administradorData = new AdministradorData(ConstanteArchivos.RUTA_USUARIOS_ESTANDAR);
    }
    
    public Usuario inicioSesion(int identificacion, String contrasenna) throws IOException {
        return this.administradorData.inicioSesion(identificacion, contrasenna);
    }
}
