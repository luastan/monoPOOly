package monopooly.sucesos.tipoSucesos;

import monopooly.configuracion.Precios;
import monopooly.player.Jugador;
import monopooly.sucesos.Suceso;

public class PagoImpuesto extends Suceso {
    private int cantidad;

    public PagoImpuesto(Jugador jugadorOriginador) {
        super(jugadorOriginador);
        this.cantidad = Precios.IMPUESTOS;
    }

    public PagoImpuesto(Jugador jugadorOriginador, int cantidad) {
        super(jugadorOriginador);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
