package monopooly.sucesos.tipoSucesos;

import monopooly.excepciones.ExcepcionMonopooly;
import monopooly.player.Jugador;
import monopooly.sucesos.Suceso;

public class ConseguirBote extends Suceso {
    private int cantidadBote;

    public ConseguirBote(Jugador jugadorOriginador, int cantidadBote) {
        super(jugadorOriginador);
        this.cantidadBote = cantidadBote;
    }

    public int getCantidadBote() {
        return cantidadBote;
    }

    public void setCantidadBote(int cantidadBote) {
        this.cantidadBote = cantidadBote;
    }

    @Override
    public String toString() {
        return "ConseguirBote{" +
                "cantidadBote=" + cantidadBote +
                '}';
    }


    @Override
    public void deshacer() throws ExcepcionMonopooly {
        super.deshacer();
        getJugadorOriginador().quitarDinero(cantidadBote);
    }
}
