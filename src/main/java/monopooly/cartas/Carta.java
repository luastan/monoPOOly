package monopooly.cartas;

import monopooly.player.Jugador;

public interface Carta {
  void aplicar();

  void deshacer();

  /**
   * Si se pago a la banca devuelve la cantidad del pago
   *
   * @return Cantidad del pago a la banca. En caso de no pagar a la banca
   * devuelve 0
   */
  int cantidadBanca();

  int modDinero();
}
