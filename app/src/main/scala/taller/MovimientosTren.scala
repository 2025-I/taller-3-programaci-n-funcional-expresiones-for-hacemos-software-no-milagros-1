package taller

import scala.annotation.tailrec

class MovimientosTren {
  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)
  type Maniobra = List[Movimiento]

  def aplicarMovimiento(estado: Estado, movimiento: Movimiento): Estado = {
    val (principal, uno, dos) = estado
    movimiento match {
      case Uno(n) if n > 0 =>
        val (resto, movidos) = principal.splitAt(principal.length - (n min principal.length))
        (resto, movidos ++ uno, dos)
      case Uno(n) if n < 0 =>
        val (movidos, resto) = uno.splitAt((-n) min uno.length)
        (principal ++ movidos, resto, dos)
      case Dos(n) if n > 0 =>
        val (resto, movidos) = principal.splitAt(principal.length - (n min principal.length))
        (resto, uno, movidos ++ dos)
      case Dos(n) if n < 0 =>
        val (movidos, resto) = dos.splitAt((-n) min dos.length)
        (principal ++ movidos, uno, resto)
      case _ => estado
    }
  }

  def aplicarMovimientos(estado: Estado, movimientos: Maniobra): List[Estado] = {
    movimientos.foldLeft(List(estado)) { (acc, mov) =>
      val nuevoEstado = aplicarMovimiento(acc.last, mov)
      acc :+ nuevoEstado
    }
  }
}