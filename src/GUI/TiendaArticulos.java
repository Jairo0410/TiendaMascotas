package GUI;

import Business.InventarioTiendaBusiness;
import Business.InventarioUsuarioBusiness;
import Business.UsuarioEstandarBusiness;
import Data.UsuarioEstandarData;
import Domain.Articulo;
import Domain.InventarioTienda;
import Domain.UsuarioEstandar;
import Utility.ManejoSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kevin
 */
public class TiendaArticulos extends JInternalFrame implements ActionListener, MouseListener {

    private JList lista;
    private JPanel panel;
    private InventarioTienda inventario;
    private InventarioTiendaBusiness invBusiness;

    private JLabel precio;
    private JLabel cantidad;
    private JLabel comprarLabel;
    private JLabel cantCreditos;

    private JTextField campo;

    private JButton comprar;

    private UsuarioEstandar usuarioActual;

    public TiendaArticulos() {
        init();
    }

    private void init() {
        panel = new JPanel();
        lista = new JList();
        campo = new JTextField();
        usuarioActual = (UsuarioEstandar) ManejoSesion.getUsuarioIniciado();

        inventario = new InventarioTienda();
        invBusiness = new InventarioTiendaBusiness();

        DefaultListModel modelo = new DefaultListModel();

        precio = new JLabel("Precio: ");
        cantidad = new JLabel("Cantidad: ");
        comprarLabel = new JLabel("Cantidad deseada");
        cantCreditos = new JLabel("Creditos: " + usuarioActual.getSaldo());

        comprar = new JButton("Comprar");

        try {

            inventario.setArticulos(invBusiness.obtenerInventario());

            for (Articulo articuo : inventario.getArticulos()) {
                modelo.addElement(articuo.getNombre());
            }
        } catch (IOException ex) {

        }

        precio.setBounds(150, 10, 100, 20);
        cantidad.setBounds(150, 30, 100, 20);
        lista.setModel(modelo);
        comprarLabel.setBounds(150, 70, 150, 20);
        campo.setBounds(150, 90, 100, 20);
        cantCreditos.setBounds(150, 110, 150, 20);

        comprar.setBounds(150, 150, 100, 20);
        comprar.addActionListener(this);

        lista.setBounds(10, 10, 100, 230);
        lista.addMouseListener(this);
        panel.setLayout(null);
        setBounds(10, 10, 300, 300);

        panel.add(precio);
        panel.add(cantidad);
        panel.add(lista);
        panel.add(comprar);
        panel.add(cantCreditos);
        panel.add(comprarLabel);
        panel.add(campo);

        setClosable(true);
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == comprar) {
            if (lista.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un articulo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            InventarioTiendaBusiness inventarioTiendaBusiness = new InventarioTiendaBusiness();
            InventarioUsuarioBusiness invUsuarioB = new InventarioUsuarioBusiness();
            UsuarioEstandarBusiness usuarioBusiness = new UsuarioEstandarBusiness();

            Articulo articuloSeleccionado = null;

            int indiceArticuloSeleccionado = 0;

            for (int i = 0; i < inventario.getArticulos().size(); i++) {
                Articulo articulo = inventario.getArticulos().get(i);

                if (articulo.getNombre().equals(lista.getSelectedValue().toString())) {
                    articuloSeleccionado = articulo;

                    indiceArticuloSeleccionado = i;
                    
                }
                
            }//se encuentra el articulo
            
            int cantComprada = Integer.parseInt(campo.getText());

            int totalCompra = articuloSeleccionado.getPrecio() * cantComprada;

            try {
                usuarioBusiness.descontarSaldo(usuarioActual, totalCompra);
                inventarioTiendaBusiness.descontarInventario(articuloSeleccionado, cantComprada);
                invUsuarioB.agregarInventario(usuarioActual, articuloSeleccionado,cantComprada);
                        
                ArrayList<Articulo> articulosActualizado = inventarioTiendaBusiness.obtenerInventario();

                inventario.setArticulos(articulosActualizado);

                precio.setText("Precio: " + inventario.getArticulos().get(indiceArticuloSeleccionado).getPrecio());
                cantidad.setText("Cantidad: " + inventario.getArticulos().get(indiceArticuloSeleccionado).getCantExistente());
                cantCreditos.setText("Creditos: " + usuarioActual.getSaldo());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
                ex.printStackTrace();
            }
            System.out.println("Sirve");

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Articulo articulo : inventario.getArticulos()) {
            if (articulo.getNombre().equals(lista.getSelectedValue().toString())) {
                precio.setText("Precio: " + articulo.getPrecio());
                cantidad.setText("Cantidad: " + articulo.getCantExistente());
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
