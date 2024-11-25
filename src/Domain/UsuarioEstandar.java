package Domain;

/**
 *
 * @author Kevin
 */
public class UsuarioEstandar extends Usuario {

    private int saldo;
    Mascota mascotas;

    public UsuarioEstandar(int saldo, int identificacion, String nombre, String contrasenna) {
        super(identificacion, nombre, contrasenna);
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void ganarCreditos() {

    }

}
