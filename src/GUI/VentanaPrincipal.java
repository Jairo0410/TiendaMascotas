package GUI;

import Domain.Usuario;
import Utility.ManejoSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Kevin
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem itemRegistarUsuario;
    private JMenuItem itemRegistrarMascota;
    private JMenuItem itemInicioSesion;
    private JMenuItem itemCerrarSesion;
    private JMenuItem itemLista;
    private JMenuItem itemListaMascota;

    private JDesktopPane escritorio;

    public VentanaPrincipal() {

        barra = new JMenuBar();
        setJMenuBar(barra);
        menu = new JMenu("Registro");
        barra.add(menu);

        itemRegistarUsuario = new JMenuItem("Registrar Usuario");
        itemRegistrarMascota = new JMenuItem("Registar Mascota");
        itemInicioSesion = new JMenuItem("Inicio Sesion");
        itemCerrarSesion = new JMenuItem("Cerrar Sesion");
        itemLista = new JMenuItem("Tienda Articulos");
        itemListaMascota = new JMenuItem("Lista Mascotas");

        menu.add(itemRegistarUsuario);
        menu.add(itemRegistrarMascota);
        menu.add(itemInicioSesion);
        menu.add(itemCerrarSesion);

        menu.add(itemLista);
        menu.add(itemListaMascota);

        itemRegistarUsuario.addActionListener(this);
        itemRegistrarMascota.addActionListener(this);
        itemInicioSesion.addActionListener(this);
        itemCerrarSesion.addActionListener(this);
        itemLista.addActionListener(this);
        itemListaMascota.addActionListener(this);

        escritorio = new JDesktopPane();

        this.setContentPane(escritorio);
        
        initVentana();

    }

    public void initVentana() {

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
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

            System.out.println("-Si o no pero");

        }

        if (e.getSource() == itemRegistrarMascota) {
            if (usuarioLog != null) {
                RegistrarMascota regMasc = new RegistrarMascota();
                this.escritorio.add(regMasc);
                System.out.println("Peerro amgu");
            } else {
                InicioSesion inicio = new InicioSesion();
                this.escritorio.add(inicio);
            }

        }

        if (e.getSource() == itemLista) {
            if (usuarioLog != null) {
                TiendaArticulos tiendaArticulos = new TiendaArticulos();
                this.escritorio.add(tiendaArticulos);
                System.out.println("Sora");
            } else {
                InicioSesion inicio = new InicioSesion();
                this.escritorio.add(inicio);
            }
        }

        if (e.getSource() == itemListaMascota) {
            if (usuarioLog != null) {
                MostrarMascota mosMas = new MostrarMascota(this.escritorio);
                this.escritorio.add(mosMas);
            } else {
                InicioSesion inicio = new InicioSesion();
                this.escritorio.add(inicio);
            }

        }

        if (e.getSource() == itemInicioSesion) {
            InicioSesion inicio = new InicioSesion();
            this.escritorio.add(inicio);
            System.out.println("Yupi");
        }

        if (e.getSource() == itemCerrarSesion) {

            ManejoSesion.cerrarSesion();
            InicioSesion inicio = new InicioSesion();
            this.escritorio.add(inicio);

        }

    }

}
