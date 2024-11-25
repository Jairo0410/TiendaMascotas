/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Business.MascotaBusiness;
import Domain.Mascota;
import Domain.Truco;
import Utility.ArregloTrucos;
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
public class Entrenamiento extends JInternalFrame implements ActionListener, MouseListener {

    private Mascota mascotas;

    private JPanel panel;

    private JLabel trucoLabel;
    private JLabel experienciaMin;
    private JLabel puntosAdquiridos;
    private JLabel experienciaRecompensa;

    private JList listaTrucos;

    private JButton entrenar;

    public Entrenamiento(Mascota mascotas) {

        this.mascotas = mascotas;
        init();

    }

    public void init() {

        panel = new JPanel();

        trucoLabel = new JLabel("Truco: ");
        experienciaMin = new JLabel("Experiencia Requerida: ");
        puntosAdquiridos = new JLabel("Puntos Adquiridos: ");
        experienciaRecompensa = new JLabel("Experiencia Adquirida: ");

        listaTrucos = new JList();

        DefaultListModel modelo = new DefaultListModel();

        for (Truco trucos : ArregloTrucos.ListaTrucos()) {
            modelo.addElement(trucos.getNombre());
        }

        entrenar = new JButton("Entrenar");

        panel.setLayout(null);
        setBounds(10, 10, 400, 400);

        listaTrucos.setModel(modelo);

        trucoLabel.setBounds(150, 10, 200, 20);
        experienciaMin.setBounds(150, 30, 200, 20);
        puntosAdquiridos.setBounds(150, 50, 200, 20);
        experienciaRecompensa.setBounds(150, 70, 200, 20);

        listaTrucos.setBounds(10, 10, 100, 230);
        listaTrucos.addMouseListener(this);

        entrenar.setBounds(150, 160, 100, 20);

        panel.add(trucoLabel);
        panel.add(experienciaMin);
        panel.add(puntosAdquiridos);
        panel.add(experienciaRecompensa);
        panel.add(listaTrucos);

        panel.add(entrenar);

        add(panel);
        setClosable(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == entrenar) {
            ArrayList<Truco> trucos = ArregloTrucos.ListaTrucos();

            Truco trucoSelecion = null;
            for (Truco skill : trucos) {
                if (skill.getNombre().equals(listaTrucos.getSelectedValue().toString())) {
                    trucoSelecion = skill;

                }
            }
            mascotas.aprenderTruco(trucoSelecion);
            MascotaBusiness mascotaBusiness = new MascotaBusiness();
            try {
                mascotaBusiness.actualizarMascota(mascotas);
            } catch (IOException ex) {
                Logger.getLogger(Entrenamiento.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ArrayList<Truco> trucos = ArregloTrucos.ListaTrucos();

        for (Truco skill : trucos) {
            if (skill.getNombre().equals(listaTrucos.getSelectedValue().toString())) {
                trucoLabel.setText("Truco: " + skill.getNombre());
                experienciaMin.setText("Experiencia Minima: " + skill.getExperienciaMinima());
                puntosAdquiridos.setText("Puntos Adquiridos: " + skill.getPuntosRecompesa());
                experienciaRecompensa.setText("Experiencia Adquirida: " + skill.getExperienciaRecompensa());

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
