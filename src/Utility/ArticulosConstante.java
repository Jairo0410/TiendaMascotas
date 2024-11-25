package Utility;

import Domain.Alimento;
import Domain.Articulo;
import Domain.Higiene;
import Domain.InventarioTienda;
import Domain.Juguete;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class ArticulosConstante {

    public static InventarioTienda obtenerInventarioInicial() {
        InventarioTienda inventario = new InventarioTienda();

        ArrayList<Articulo> articulos = new ArrayList<>();

        articulos.add(new Juguete(10, 1, "Pelota", 200, 20));
        articulos.add(new Juguete(20, 25, "Hueso de goma", 300, 20));
        articulos.add(new Juguete(5, 77, "Pollo sonoro", 100, 20));
        articulos.add(new Juguete(50, 100, "Frisbee", 600, 20));

        articulos.add(new Alimento(50, 80, "Proteina", 1500, 20));
        articulos.add(new Alimento(20, 82, "Croquetas", 500, 20));
        articulos.add(new Alimento(30, 84, "Enlatado", 800, 20));
        articulos.add(new Alimento(10, 86, "Semillas", 600, 20));

        articulos.add(new Higiene(120, 50, "Shampoo", 2000, 20));
        articulos.add(new Higiene(200, 55, "Talco Pulguicida", 1000, 20));
        articulos.add(new Higiene(100, 60, "Repelente", 200, 20));
        articulos.add(new Higiene(30, 65, "Pasta Dental", 2000, 20));

        inventario.setArticulos(articulos);
        
        return inventario;

    }

}
