package tiendamascotaskevinfuentessemestreiianno2024;

import Business.InventarioTiendaBusiness;
import Data.InventarioTiendaData;
import GUI.VentanaPrincipal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class TiendaMascotasKevinFuentesSemestreIIAnno2024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InventarioTiendaBusiness inventarioTienda=new InventarioTiendaBusiness();
        try {
            inventarioTienda.guardarInvInicial();
        } catch (IOException ex) {
            Logger.getLogger(TiendaMascotasKevinFuentesSemestreIIAnno2024.class.getName()).log(Level.SEVERE, null, ex);
        }
        VentanaPrincipal vnw=new VentanaPrincipal();
        vnw.setVisible(true);
    }
    
}
