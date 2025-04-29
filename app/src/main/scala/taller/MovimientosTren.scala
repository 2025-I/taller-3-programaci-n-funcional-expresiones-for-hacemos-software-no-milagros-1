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
  def definirManiobra(t1: Tren, t2: Tren): Maniobra = {
    @tailrec
    def aux(pendiente: Tren, objetivo: Tren, maniobra: Maniobra, estado: Estado): Maniobra = {
      objetivo match {
        case Nil => maniobra
        case cabezaObjetivo :: restoObjetivo =>
          val (principal, uno, dos) = estado
          if (principal.nonEmpty && principal.head == cabezaObjetivo) {
            aux(principal.tail, restoObjetivo, maniobra, (principal.tail, uno, dos))
          } else {
            if (principal.contains(cabezaObjetivo)) {
              val index = principal.indexOf(cabezaObjetivo)
              val movimientos = List(Uno(principal.length - index))
              val nuevoEstado = aplicarMovimiento(estado, movimientos.head)
              aux(nuevoEstado._1, objetivo, maniobra ++ movimientos, nuevoEstado)
            } else if (uno.contains(cabezaObjetivo)) {
              val index = uno.indexOf(cabezaObjetivo)
              val movimientos = List(Uno(-(index + 1)))
              val nuevoEstado = aplicarMovimiento(estado, movimientos.head)
              aux(nuevoEstado._1, objetivo, maniobra ++ movimientos, nuevoEstado)
            } else if (dos.contains(cabezaObjetivo)) {
              val index = dos.indexOf(cabezaObjetivo)
              val movimientos = List(Dos(-(index + 1)))
              val nuevoEstado = aplicarMovimiento(estado, movimientos.head)
              aux(nuevoEstado._1, objetivo, maniobra ++ movimientos, nuevoEstado)
            } else {
              if (principal.nonEmpty) {
                val movimientos = List(Uno(1))
                val nuevoEstado = aplicarMovimiento(estado, movimientos.head)
                aux(nuevoEstado._1, objetivo, maniobra ++ movimientos, nuevoEstado)
              } else {
                maniobra
              }
            }
          }
      }
    }
    val estadoInicial = (t1, Nil, Nil)
    aux(t1, t2, Nil, estadoInicial)
  }
}