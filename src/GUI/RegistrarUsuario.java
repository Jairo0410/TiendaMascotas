package GUI;

import Data.AdministradorData;
import Domain.UsuarioEstandar;
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
public class RegistrarUsuario extends JInternalFrame implements ActionListener {

    JPanel panel;
    JLabel idLabel;
    JLabel nombreLabel;
    JLabel contraLabel;
    JTextField idUsuario;
    JTextField nombreT;
    JPasswordField contrasennaT;

    JButton registrar;

    public RegistrarUsuario() {

        panel = new JPanel();
        
        panel.setLayout(null);
        setBounds(10, 10, 300, 300);
        
        idLabel = new JLabel("Identificacion");
        idUsuario = new JTextField();

        nombreLabel = new JLabel("Nombre");
        nombreT = new JTextField();

        contraLabel = new JLabel("Contraseña");
        contrasennaT = new JPasswordField();

        registrar = new JButton("Registrar");
        registrar.addActionListener(this);
        

        idLabel.setBounds(10, 10, 100, 20);
        idUsuario.setBounds(100, 10, 100, 20);

        nombreLabel.setBounds(10, 30, 100, 20);
        nombreT.setBounds(100, 30, 100, 20);

        contraLabel.setBounds(10,50,100,20);
        contrasennaT.setBounds(100,50,100,20);
        
        registrar.setBounds(50, 160, 100, 20);

        panel.add(idLabel);
        panel.add(nombreLabel);
        panel.add(contraLabel);

        panel.add(idUsuario);
        panel.add(nombreT);
        panel.add(contrasennaT);

        panel.add(registrar);
        panel.setSize(300, 300);
        
        setClosable(true);

        add(panel);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AdministradorData adminData = new AdministradorData("archivoAdmin.txt");
        if (e.getSource() == registrar) {
            int usuarioID = Integer.parseInt(idUsuario.getText());
            String nombre=nombreT.getText();
            String contra=contrasennaT.getText();
            
            try{   
                adminData.guardarUsuario(new UsuarioEstandar(5000, usuarioID, nombre, contra));
            } catch (IOException ex) {
                Logger.getLogger(RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
