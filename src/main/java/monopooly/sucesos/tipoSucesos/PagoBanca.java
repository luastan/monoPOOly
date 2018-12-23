package monopooly.sucesos.tipoSucesos;

import monopooly.player.Jugador;
import monopooly.sucesos.Suceso;

public class PagoBanca extends Suceso {

    private int cantidad;
    private String explicacion;

    public PagoBanca(Jugador jugadorOriginador, int cantidad, String explicacion) {
        super(jugadorOriginador);
        this.cantidad = cantidad;
        this.explicacion = explicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }
}
