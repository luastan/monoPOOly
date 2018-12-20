package monopooly.configuracion;

public class Nombres {
    public static String[] CALLES = {
            "Salida",

            "Murcia",
            "Caja",
            "A Coruña",
            "IRPF",

            "Invierno",

            "Plasencia",
            "suerte",
            "Ciudad Real",
            "Almería",

            "Carcel",

            "Toledo",
            "Desatranques J",
            "Teruel",
            "Getafe",

            "Otoño",

            "Zaragoza",
            "Caja",
            "Lugo",
            "Vigo",

            "Parking",

            "Salamanca",
            "suerte",
            "Cádiz",
            "Sevilla",

            "Verano",

            "Oviedo",
            "Valladolid",
            "Fontaneria",
            "Valencia",

            "Ir a carcel",

            "Bilbao",
            "Barcelona",
            "Caja",
            "Madrid",

            "Primavera",

            "suerte",
            "Marbella",
            "IVA",
            "Ibiza",
    };

    public static final String AYUDA_NOMBRE = "NAME:";
    public static final String AYUDA_SYNOPSIS = "SYNOPSIS:";
    public static final String AYUDA_DESCRIPCION = "DESCRIPTION:";
    public static final String[] LISTA_COMANDOS = {
            "lanzar dados  -  Lanza los dados",
            "describir     -  Describe elementos",
            "jugador       -  Informacion del jugador actual",
            "comprar       -  Comprar una propiedad",
            "salir carcel  -  Salir de la carcel",
            "bancarrota    -  Declarar bancarrota",
            "listar        -  Lista elementos",
            "acabar turno  -  Termina el turno",
            "cambiar modo  -  Activa el movimiento especial",
            "ver tablero   -  Muestra el tablero"
    };


    public static int maxLen() {
        int max = 0;
        for (String nombre :
                CALLES) {
            if (nombre.length() > max) {
                max = nombre.length();
            }
        }
        return max;
    }
}
