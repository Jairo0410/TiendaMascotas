package GUI;

import Business.MascotaBusiness;
import Business.UsuarioEstandarBusiness;
import Data.MascotaData;
import Data.UsuarioEstandarData;
import Domain.Mascota;
import Domain.Perro;
import Domain.Gato;
import Domain.Ave;
import Domain.Usuario;
import Domain.UsuarioEstandar;
import Utility.ManejoSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kevin
 */
public class RegistrarMascota extends JInternalFrame implements ActionListener, ItemListener {

    private JPanel panel;

    private JLabel nombreLabel;
    private JLabel descLabel;
    private JLabel edadLabel;
    private JLabel tipoLabel;
    private JLabel valorMascota;

    private JTextField nombreT;
    private JTextField desT;
    private JTextField edadT;
    private JComboBox<String> tipoT;

    private JButton registrar;
    private UsuarioEstandar uEstandar;
    private UsuarioEstandarData usData;

    public RegistrarMascota() {

        init();
        setBounds(10, 10, 300, 300);
    }

    public void init() {
        panel = new JPanel();

        nombreLabel = new JLabel("Nombre");
        descLabel = new JLabel("Descripcion");
        edadLabel = new JLabel("Edad");
        tipoLabel = new JLabel("Tipo");
        valorMascota = new JLabel("Valor: ");

        nombreT = new JTextField();
        desT = new JTextField();
        edadT = new JTextField();
        tipoT = new JComboBox<>();

        registrar = new JButton("Registrar");
        registrar.addActionListener(this);

        panel.setLayout(null);

        nombreLabel.setBounds(10, 10, 100, 20);
        descLabel.setBounds(10, 30, 100, 20);
        edadLabel.setBounds(10, 50, 100, 20);
        tipoLabel.setBounds(10, 70, 100, 20);
        valorMascota.setBounds(10, 100, 100, 20);

        nombreT.setBounds(90, 10, 100, 20);
        desT.setBounds(90, 30, 100, 20);
        edadT.setBounds(90, 50, 100, 20);
        tipoT.setBounds(90, 70, 100, 20);

        tipoT.addItem("Perro");
        tipoT.addItem("Gato");
        tipoT.addItem("Ave");

        tipoT.addItemListener(this);

        registrar.setBounds(50, 160, 100, 20);

        panel.add(nombreLabel);
        panel.add(descLabel);
        panel.add(edadLabel);
        panel.add(tipoLabel);
        panel.add(valorMascota);

        panel.add(nombreT);
        panel.add(desT);
        panel.add(edadT);
        panel.add(tipoT);

        panel.add(registrar);

        panel.setSize(300, 300);

        add(panel);
        setClosable(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MascotaBusiness masData = new MascotaBusiness();
        Mascota mascotaSeleccionada = null;

        if (e.getSource() == registrar) {
            String nombre = nombreT.getText();
            String descripcion = desT.getText();
            int edad = Integer.parseInt(edadT.getText());
            String tipo = tipoT.getSelectedItem().toString();
            
            UsuarioEstandar usuarioInicio = (UsuarioEstandar) ManejoSesion.getUsuarioIniciado();
            if (tipo.equals("Perro")) {
                mascotaSeleccionada = new Perro(nombre, descripcion, edad, tipo, usuarioInicio.getIdentificacion());
            } else if (tipo.equals("Gato")) {
                mascotaSeleccionada = new Gato(nombre, descripcion, edad, usuarioInicio.getIdentificacion());
            } else {
                mascotaSeleccionada = new Ave(nombre, descripcion, edad, usuarioInicio.getIdentificacion());
            }

            UsuarioEstandarBusiness usuarioEstandarBusi = new UsuarioEstandarBusiness();

            try {
                usuarioEstandarBusi.descontarSaldo(usuarioInicio, mascotaSeleccionada.getPrecio());
                masData.registrarMascota(mascotaSeleccionada, usuarioInicio);
                

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == tipoT) {
            tipoT.getSelectedItem().toString();
            System.out.println(tipoT.getSelectedItem().toString());
            if (tipoT.getSelectedItem().toString().equals("Perro")) {
                valorMascota.setText("Valor: " + String.valueOf((new Perro()).getPrecio()));
            } else if (tipoT.getSelectedItem().toString().equals("Gato")) {
                valorMascota.setText("Valor: " + String.valueOf((new Gato()).getPrecio()));
            } else {
                valorMascota.setText("Valor: " + String.valueOf((new Ave()).getPrecio()));
            }

        }
    }

}
