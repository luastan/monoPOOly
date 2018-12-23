package monopooly.entradaSalida;

import monopooly.colocacion.Casilla;
import monopooly.excepciones.ExcepcionMonopooly;
import monopooly.player.Avatar;
import monopooly.player.Jugador;

public interface Comando {
    /**
     * Permite a un jugador comprar una casilla. Se hacen las comprobaciones de si puede comprarla
     * @param jugador Jugador que comprar
     * @param casilla Casilla que se quiere comprar
     */
    void comprar(Jugador jugador, Casilla casilla) throws ExcepcionMonopooly;

    void lanzar(Jugador jugador);

    void hipotecar(Jugador jugador,Casilla casilla);

    void vender(Jugador jugador);

    void deshipotecar(Jugador jugador,Casilla casilla);

    void info(Jugador jugador);

    void describirJugador(Jugador jugador);

    void describirCasilla(Casilla casilla);

    void describirAvatar(Avatar avatar);

    void salirCarcel(Jugador jugador);

    void verTablero();

    void cambiarModo(Avatar avatar);

    void bancarrota(Jugador jugador);
}

