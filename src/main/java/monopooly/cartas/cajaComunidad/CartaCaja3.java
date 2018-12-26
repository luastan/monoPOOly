package monopooly.cartas.cajaComunidad;

import monopooly.cartas.CajaComunidad;
import monopooly.colocacion.Posicion;
import monopooly.colocacion.Tablero;
import monopooly.configuracion.Posiciones;
import monopooly.configuracion.Precios;
import monopooly.excepciones.ExcepcionCarta;
import monopooly.excepciones.ExcepcionMonopooly;
import monopooly.player.Jugador;

public class CartaCaja3 extends CajaComunidad {
    private static final int DINERO = 0;
    private static final String MENSAJE = ""
            + "Colocate en la casilla de salida. \n"
            + "cobra " + Precios.SALIDA + " " + Precios.MONEDA
            + "";


    @Override
    public void accion() throws ExcepcionMonopooly {
        Jugador jugador = Tablero.getPrompt().getJugador();
        jugador.getAvatar().moverAvatar(new Posicion(Posiciones.SALIDA));
        throw new ExcepcionCarta(MENSAJE, this); // Permite que los movimientos especiales sigan con normalidad
    }

    @Override
    public String getMensaje() {
        return MENSAJE;
    }

    @Override
    public void deshacer() {
        /* El pago de ve a la carcel y el movimiento se deshacen solos, se genera en mover avatar el suceso */
    }


    @Override
    public int modDinero() {
        return DINERO;
    }
}
