/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Business.InventarioUsuarioBusiness;
import Business.MascotaBusiness;
import Business.UsuarioEstandarBusiness;
import Domain.Articulo;
import Domain.Mascota;
import Domain.Truco;
import Domain.UsuarioEstandar;
import Utility.ArregloTrucos;
import Utility.ManejoSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Kevin
 */
public class InteractuarMascota extends JInternalFrame implements MouseListener, ActionListener {
    private Mascota mascotas;

    private JPanel panel;

    private JLabel nombreArticuloLabel;
    private JLabel cantidadArticuloLabel;
    private JLabel efectoArticuloLabel;
    
    private JLabel nombreMascotaLabel;
    private JLabel vidaMascotaLabel;
    private JLabel diversionMascotaLabel;
    private JLabel experienciaMascotaLabel;

    private JList listaArticulos;

    private JButton usarArticuloBoton;
    private InventarioUsuarioBusiness invUsuarioBusiness;
    private UsuarioEstandar usuario;
    
    private ArrayList<Articulo> articulos;

    public InteractuarMascota(Mascota mascotas) {

        this.mascotas = mascotas;
        this.invUsuarioBusiness = new InventarioUsuarioBusiness();
        init();

    }

    public void init() {

        panel = new JPanel();

        nombreArticuloLabel = new JLabel("Nombre: ");
        cantidadArticuloLabel = new JLabel("Cantidad: ");
        efectoArticuloLabel = new JLabel("Efecto: ");
        
        nombreMascotaLabel = new JLabel("Nombre: " + mascotas.getNombre());
        vidaMascotaLabel = new JLabel("Vida: " + mascotas.getVida());
        diversionMascotaLabel = new JLabel("Diversion: " + mascotas.getNivelDiversion());
        experienciaMascotaLabel = new JLabel("Experiencia: " + mascotas.getExperiencia());
        
        usuario = (UsuarioEstandar) ManejoSesion.getUsuarioIniciado();

        listaArticulos = new JList();

        DefaultListModel modelo = new DefaultListModel();

        try {
            this.articulos = invUsuarioBusiness.obtenerInventarioUsuario(usuario.getIdentificacion());
            
            for (Articulo articulo : this.articulos) {
                modelo.addElement(articulo.getNombre());
            }
        } catch (IOException ex) {
            Logger.getLogger(InteractuarMascota.class.getName()).log(Level.SEVERE, null, ex);
        }

        usarArticuloBoton = new JButton("Usar");

        panel.setLayout(null);
        setBounds(10, 10, 400, 400);

        listaArticulos.setModel(modelo);

        nombreArticuloLabel.setBounds(150, 10, 200, 20);
        cantidadArticuloLabel.setBounds(150, 30, 200, 20);
        efectoArticuloLabel.setBounds(150, 50, 200, 20);
        
        nombreMascotaLabel.setBounds(150, 90, 200, 20);
        diversionMascotaLabel.setBounds(150, 110, 200, 20);
        vidaMascotaLabel.setBounds(150, 130, 200, 20);
        experienciaMascotaLabel.setBounds(150, 150, 200, 20);
        

        listaArticulos.setBounds(10, 10, 100, 230);
        listaArticulos.addMouseListener(this);

        usarArticuloBoton.setBounds(150, 180, 100, 20);

        panel.add(nombreArticuloLabel);
        panel.add(cantidadArticuloLabel);
        panel.add(efectoArticuloLabel);
        
        panel.add(listaArticulos);
        
        panel.add(nombreMascotaLabel);
        panel.add(vidaMascotaLabel);
        panel.add(diversionMascotaLabel);
        panel.add(experienciaMascotaLabel);

        panel.add(usarArticuloBoton);
        
        usarArticuloBoton.addActionListener(this);
        
        iniciarConteoVida();

        add(panel);
        setClosable(true);
        setVisible(true);
    }
    
    public void iniciarConteoVida() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MascotaBusiness mascotaBusiness = new MascotaBusiness();
                
                mascotas.actualizarPorcentajeVida();
                
                try {
                    mascotaBusiness.actualizarMascota(mascotas);
                } catch (IOException ex) {
                    Logger.getLogger(InteractuarMascota.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                vidaMascotaLabel.setText("Vida: " + mascotas.getVida());
                diversionMascotaLabel.setText("Diversion: " + mascotas.getNivelDiversion());
                experienciaMascotaLabel.setText("Experiencia: " + mascotas.getExperiencia());
            }
        });
        
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usarArticuloBoton) {

            Articulo articuloSeleccionado = null;
            for (Articulo articulo : articulos) {
                if (articulo.getNombre().equals(listaArticulos.getSelectedValue().toString())) {
                    articuloSeleccionado = articulo;
                }
            }
            
            
            
            MascotaBusiness mascotaBusiness = new MascotaBusiness();
            try {
                invUsuarioBusiness.descontarInventario(usuario, articuloSeleccionado, 1);
                articuloSeleccionado.efectoArticulo(mascotas);
                mascotaBusiness.actualizarMascota(mascotas);
                
                articulos = invUsuarioBusiness.obtenerInventarioUsuario(usuario.getIdentificacion());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            for (Articulo articulo : this.articulos) {
                if (listaArticulos.getSelectedValue() != null && articulo.getNombre().equals(listaArticulos.getSelectedValue().toString())) {
                    efectoArticuloLabel.setText("Efecto: " + articulo.getEfecto());
                    nombreArticuloLabel.setText("Nombre: " + articulo.getNombre());
                    cantidadArticuloLabel.setText("Cantidad: " + articulo.getCantExistente());
                }
            }
            
            vidaMascotaLabel.setText("Vida: " + mascotas.getVida());
            diversionMascotaLabel.setText("Diversion: " + mascotas.getNivelDiversion());
            experienciaMascotaLabel.setText("Experiencia: " + mascotas.getExperiencia());

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Articulo articulo : this.articulos) {
            if (listaArticulos.getSelectedValue() != null && articulo.getNombre().equals(listaArticulos.getSelectedValue().toString())) {
                efectoArticuloLabel.setText("Efecto: " + articulo.getEfecto());
                nombreArticuloLabel.setText("Nombre: " + articulo.getNombre());
                cantidadArticuloLabel.setText("Cantidad: " + articulo.getCantExistente());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
