/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.UsuarioEstandarData;
import Domain.UsuarioEstandar;
import Utility.ConstanteArchivos;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Kevin
 */
public class UsuarioEstandarBusiness {
    private UsuarioEstandarData usuarioEstandarData;
    
    public UsuarioEstandarBusiness() {
        usuarioEstandarData = new UsuarioEstandarData(ConstanteArchivos.RUTA_USUARIOS_ESTANDAR);
    }
    
    public boolean descontarSaldo(UsuarioEstandar usuario, int saldo) throws IOException, Exception {
        if (usuario.getSaldo() < saldo) {
            throw new Exception("Usuario no tiene suficiente saldo");
        }
        
        usuario.setSaldo(usuario.getSaldo() - saldo);
        return usuarioEstandarData.actualizarUsuario(usuario);
    }
}
