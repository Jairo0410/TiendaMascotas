package GUI;

import Domain.Usuario;
import Utility.ManejoSesion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Kevin
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private JMenuBar barra;
    private JMenu menuUsuario;
    private JMenu menuMascotas;
    private JMenu menuTienda;

    private JMenuItem itemRegistarUsuario;
    private JMenuItem itemRegistrarMascota;
    private JMenuItem itemInicioSesion;
    private JMenuItem itemCerrarSesion;
    private JMenuItem itemListaArticulos;
    private JMenuItem itemListaMascota;

    private JDesktopPane escritorio;

    

    public VentanaPrincipal() {


        
        barra = new JMenuBar();
        setJMenuBar(barra);
        menuUsuario = new JMenu("Usuario");
        menuMascotas = new JMenu("Mascotas");
        menuTienda = new JMenu("Tienda");

        barra.add(menuUsuario);
        barra.add(menuMascotas);
        barra.add(menuTienda);

        itemRegistarUsuario = new JMenuItem("Registrar Usuario");
        itemRegistrarMascota = new JMenuItem("Registar Mascota");
        itemInicioSesion = new JMenuItem("Inicio Sesion");
        itemCerrarSesion = new JMenuItem("Cerrar Sesion");
        itemListaArticulos = new JMenuItem("Tienda Articulos");
        itemListaMascota = new JMenuItem("Lista Mascotas");

        menuUsuario.add(itemRegistarUsuario);
        menuUsuario.add(itemInicioSesion);
        menuUsuario.add(itemCerrarSesion);

        menuTienda.add(itemListaArticulos);

        menuMascotas.add(itemListaMascota);
        menuMascotas.add(itemRegistrarMascota);

        itemRegistarUsuario.addActionListener(this);
        itemRegistrarMascota.addActionListener(this);
        itemInicioSesion.addActionListener(this);
        itemCerrarSesion.addActionListener(this);
        itemListaArticulos.addActionListener(this);
        itemListaMascota.addActionListener(this);
        
        
        escritorio = new JDesktopPane();
     
        this.setContentPane(escritorio);
               
        initVentana();

    }

    public void initVentana() {

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Usuario usuarioLog = ManejoSesion.getUsuarioIniciado();

        if (e.getSource() == itemRegistarUsuario) {
            RegistrarUsuario regUsu = new RegistrarUsuario();
            this.escritorio.add(regUsu);
        }

        if (e.getSource() == itemRegistrarMascota) {
            if (usuarioLog != null) {
                RegistrarMascota regMasc = new RegistrarMascota();
                this.escritorio.add(regMasc);

            } else {
                InicioSesion inicio = new InicioSesion();
                this.escritorio.add(inicio);
            }

        }

        if (e.getSource() == itemListaArticulos) {
            if (usuarioLog != null) {
                TiendaArticulos tiendaArticulos = new TiendaArticulos();
                this.escritorio.add(tiendaArticulos);

            } else {
                InicioSesion inicio = new InicioSesion();
                this.escritorio.add(inicio);
            }
        }

        if (e.getSource() == itemListaMascota) {
            if (usuarioLog != null) {
                MostrarMascota mosMas = new MostrarMascota();
                this.escritorio.add(mosMas);
            } else {
                InicioSesion inicio = new InicioSesion();
                this.escritorio.add(inicio);
            }

        }

        if (e.getSource() == itemInicioSesion) {
            InicioSesion inicio = new InicioSesion();
            this.escritorio.add(inicio);

        }

        if (e.getSource() == itemCerrarSesion) {

            ManejoSesion.cerrarSesion();
            InicioSesion inicio = new InicioSesion();
            this.escritorio.add(inicio);

        }

    }

}
