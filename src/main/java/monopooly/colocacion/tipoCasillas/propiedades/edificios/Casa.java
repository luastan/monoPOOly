package monopooly.colocacion.tipoCasillas.propiedades.edificios;

import monopooly.colocacion.tipoCasillas.propiedades.tiposPropiedad.Solar;
import monopooly.configuracion.Precios;

import java.util.Iterator;
import java.util.stream.Stream;

public class Casa extends Edificio {

    private final static Iterator<Integer> generadorId = Stream.iterate(0, i -> i + 1).iterator();

    public Casa(Solar solar) {
        super(generadorId.next(), solar,(int)(solar.getPrecio()* Precios.VALOR_CASA));
    }
}
