package GUI;

import Data.AdministradorData;
import Domain.UsuarioEstandar;
import Utility.ManejoSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Kevin
 */
public class InicioSesion extends JInternalFrame implements ActionListener {

    private JLabel identifacion;
    private JLabel contrase;

    private JTextField idT;
    private JPasswordField contraT;

    private JButton botonInicio;

    private JPanel panel;

    public InicioSesion() {

        init();

    }

    public void init() {

        panel = new JPanel();

        identifacion = new JLabel("Identifacion");
        idT = new JTextField();

        contrase = new JLabel("Contraseña");
        contraT = new JPasswordField();

        botonInicio = new JButton("Iniciar");
        botonInicio.addActionListener(this);

        identifacion.setBounds(10, 10, 100, 20);
        idT.setBounds(100, 10, 100, 20);

        contrase.setBounds(10, 50, 100, 20);
        contraT.setBounds(100, 50, 100, 20);

        botonInicio.setBounds(50, 100, 100, 20);

        panel.setLayout(null);
        setBounds(10, 10, 250,250);

        panel.add(identifacion);
        panel.add(idT);
        panel.add(contrase);
        panel.add(contraT);

        panel.add(botonInicio);
      

        add(panel);
        
        setClosable(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        AdministradorData adminData = new AdministradorData("archivoAdmin.txt");

        if (e.getSource() == botonInicio) {
            int identificacion = Integer.parseInt(idT.getText());
            String contras = new String(contraT.getPassword());

            try {
                UsuarioEstandar usuario = (UsuarioEstandar) adminData.inicioSesion(identificacion, contras);

                ManejoSesion.guardarSesion(usuario);

            } catch (IOException ex) {
                Logger.getLogger(RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
