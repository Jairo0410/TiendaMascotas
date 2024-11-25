/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Data.MascotaData;
import Domain.Mascota;
import Utility.ManejoSesion;
import java.awt.Container;
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
import javax.swing.JPanel;

/**
 *
 * @author Kevin
 */
public class MostrarMascota extends JInternalFrame implements MouseListener, ActionListener {

    private JLabel nombreLabel;
    private JLabel descLabel;
    private JLabel edadLabel;
    private JLabel vidaLabel;
    private JLabel nivelLabel;
    private JLabel experienciaLabel;
    private JLabel tipoLabel;

    private JList listaMascotas;

    private MascotaData mascostaData;

    private JPanel panel;

    private JButton entrenarBoton;
    private JButton interactuarBoton;

    private ArrayList<Mascota> mascotasUsuario;

    public MostrarMascota() {
        init();
    }

    public void init() {
        mascostaData = new MascotaData("mascotas.bin");
        panel = new JPanel();

        DefaultListModel modelo = new DefaultListModel();

        listaMascotas = new JList();

        nombreLabel = new JLabel("Nombre");
        descLabel = new JLabel("Descripcion");
        edadLabel = new JLabel("Edad");
        vidaLabel = new JLabel("Vida");
        nivelLabel = new JLabel("Nivel");
        experienciaLabel = new JLabel("Experiencia");
        tipoLabel = new JLabel("Tipo");
        
        entrenarBoton = new JButton("Entrenar");
        interactuarBoton = new JButton("Interactuar");

        nombreLabel.setBounds(150, 10, 100, 20);
        descLabel.setBounds(150, 30, 100, 20);
        edadLabel.setBounds(150, 50, 100, 20);
        vidaLabel.setBounds(150, 70, 100, 20);
        nivelLabel.setBounds(150, 90, 100, 20);
        experienciaLabel.setBounds(150, 110, 100, 20);
        tipoLabel.setBounds(150, 130, 100, 20);
        
        entrenarBoton.setBounds(150, 170, 100, 20);
        interactuarBoton.setBounds(150, 200, 100, 20);

        try {
            mascotasUsuario = mascostaData.obtenerMascotasUsuario(ManejoSesion.getUsuarioIniciado().getIdentificacion());

            for (Mascota mascota : mascotasUsuario) {
                modelo.addElement(mascota.getNombre());
            }

        } catch (IOException ex) {
            Logger.getLogger(MostrarMascota.class.getName()).log(Level.SEVERE, null, ex);
        }

        listaMascotas.setModel(modelo);

        listaMascotas.setBounds(10, 10, 100, 230);

        entrenarBoton.addActionListener(this);
        interactuarBoton.addActionListener(this);
        
        listaMascotas.addMouseListener(this);

        panel.setLayout(null);
        setBounds(10, 10, 300, 300);

        panel.add(nombreLabel);
        panel.add(descLabel);
        panel.add(edadLabel);
        panel.add(vidaLabel);
        panel.add(nivelLabel);
        panel.add(experienciaLabel);
        panel.add(tipoLabel);
        
        panel.add(interactuarBoton);
        panel.add(entrenarBoton);

        panel.add(listaMascotas);

        setClosable(true);
        add(panel);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == entrenarBoton) {

            Mascota mascotaSeleccionada = null;
            for (Mascota mascotas : mascotasUsuario) {

                if (mascotas.getNombre().equals(listaMascotas.getSelectedValue().toString())) {
                    mascotaSeleccionada = mascotas;
                }

            }
            if (mascotaSeleccionada != null) {
                this.getParent().add(new Entrenamiento(mascotaSeleccionada));
            }
    
        }
        
        if (e.getSource() == interactuarBoton) {
            Mascota mascotaSeleccionada = null;
            for (Mascota mascotas : mascotasUsuario) {

                if (mascotas.getNombre().equals(listaMascotas.getSelectedValue().toString())) {
                    mascotaSeleccionada = mascotas;
                }

            }
            if (mascotaSeleccionada != null) {
                InteractuarMascota interactuarMascota = new InteractuarMascota(mascotaSeleccionada);
                this.getParent().add(interactuarMascota);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        for (Mascota mascotas : mascotasUsuario) {
            if (mascotas.getNombre().equals(listaMascotas.getSelectedValue().toString())) {
                nombreLabel.setText("Nombre: " + mascotas.getNombre());
                descLabel.setText("Descripcion: " + mascotas.getDescripcion());
                edadLabel.setText("Edad: " + mascotas.getEdad());
                vidaLabel.setText("Vida: " + mascotas.getVida());
                nivelLabel.setText("Nivel: " + mascotas.getNivelDiversion());
                experienciaLabel.setText("Experiencia: " + mascotas.getExperiencia());
                tipoLabel.setText("Tipo: " + mascotas.getTipo());
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
