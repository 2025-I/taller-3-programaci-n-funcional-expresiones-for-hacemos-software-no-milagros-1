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
    @tailrec
    def aux(pendientes: Maniobra, estados: List[Estado]): List[Estado] = pendientes match {
      case Nil => estados
      case movimiento :: resto =>
        val nuevoEstado = aplicarMovimiento(estados.last, movimiento)
        aux(resto, estados :+ nuevoEstado)
    }

    aux(movimientos, List(estado))
  }

  def definirManiobra(t1: Tren, t2: Tren): Maniobra = {
    @tailrec
    def aux(objetivo: Tren, maniobra: Maniobra, estado: Estado): Maniobra = {
      objetivo match {
        case Nil => maniobra
        case cabezaObjetivo :: restoObjetivo =>
          val (principal, uno, dos) = estado

          if (principal.nonEmpty && principal.head == cabezaObjetivo) {
            val nuevoEstado = (principal.tail, uno, dos)
            aux(restoObjetivo, maniobra, nuevoEstado)

          } else {
            val posicionPrincipal = (for ((v, i) <- principal.zipWithIndex if v == cabezaObjetivo) yield i).headOption
            val posicionUno = (for ((v, i) <- uno.zipWithIndex if v == cabezaObjetivo) yield i).headOption
            val posicionDos = (for ((v, i) <- dos.zipWithIndex if v == cabezaObjetivo) yield i).headOption

            (posicionPrincipal, posicionUno, posicionDos) match {
              case (Some(i), _, _) =>
                val mov = Uno(principal.length - i)
                val nuevoEstado = aplicarMovimiento(estado, mov)
                aux(objetivo, maniobra :+ mov, nuevoEstado)

              case (_, Some(i), _) =>
                val mov = Uno(-(i + 1))
                val nuevoEstado = aplicarMovimiento(estado, mov)
                aux(objetivo, maniobra :+ mov, nuevoEstado)

              case (_, _, Some(i)) =>
                val mov = Dos(-(i + 1))
                val nuevoEstado = aplicarMovimiento(estado, mov)
                aux(objetivo, maniobra :+ mov, nuevoEstado)

              case _ =>
                if (principal.nonEmpty) {
                  val mov = Uno(1)
                  val nuevoEstado = aplicarMovimiento(estado, mov)
                  aux(objetivo, maniobra :+ mov, nuevoEstado)
                } else {
                  maniobra
                }
            }
          }
      }
    }

    val estadoInicial = (t1, Nil, Nil)
    aux(t2, Nil, estadoInicial)
  }
}
