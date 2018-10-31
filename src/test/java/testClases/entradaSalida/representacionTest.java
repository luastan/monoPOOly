package testClases.entradaSalida;

import monopooly.colocacion.Tablero;
import monopooly.colocacion.calles.Inmueble;
import monopooly.colocacion.calles.Monopolio;
import monopooly.colocacion.calles.TipoMonopolio;
import monopooly.configuracion.ReprASCII;
import monopooly.entradaSalida.PintadoASCII;
import monopooly.player.Jugador;
import monopooly.player.tipoAvatar;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class representacionTest {
    private Inmueble solarEjemplo;
    private static Tablero tableroPrueba;
    private static Jugador monguer;

    @BeforeClass
    public static void preSetUp() {
        System.out.println("whatever");
        monguer = new Jugador("pepe", tipoAvatar.sombrero);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        listaJugadores.add(monguer);
        listaJugadores.add(new Jugador("manolo", tipoAvatar.esfinge));
        listaJugadores.add(new Jugador("federico", tipoAvatar.esfinge));
        listaJugadores.add(new Jugador("jaime", tipoAvatar.esfinge));
        listaJugadores.add(new Jugador("dani", tipoAvatar.esfinge));
        listaJugadores.add(new Jugador("saul", tipoAvatar.esfinge));
        tableroPrueba = new Tablero(listaJugadores);
    }

    @Before
    public void setUp() {

    }

    @Ignore
    public void asciiArt() {
        for (String linea : ReprASCII.ASCII_TITLE_ARRAY) {
            System.out.println(linea + " " + linea.length());
        }
    }

    @Test
    public void imprimeTablero() {
        System.out.println(PintadoASCII.genTablero(tableroPrueba));
    }

    @Test
    public void moverJugadorRepresentar() {
        monguer.moverJugador(tableroPrueba);
        System.out.println(PintadoASCII.genTablero(tableroPrueba));
    }

    @Test
    public void testPromptBasic() {
        System.out.println(PintadoASCII.basicPrompt(tableroPrueba, monguer));
    }

    @Test
    public void testPromptHelp() {
        System.out.println(PintadoASCII.basicPromptHelp(tableroPrueba, monguer));
    }
}
