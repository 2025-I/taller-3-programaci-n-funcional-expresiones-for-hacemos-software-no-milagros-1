package taller

import org.scalatest.funsuite.AnyFunSuite

class AplicarMovimientosTest extends AnyFunSuite {

  val movimientosTren = new MovimientosTren()

  test("Aplicar secuencia de movimientos simples") {
    val estadoInicial = (List('a', 'b', 'c'), Nil, Nil)
    val movimientos = List(Uno(1), Dos(1))
    val resultado = movimientosTren.aplicarMovimientos(estadoInicial, movimientos)

    val esperado = List(
      (List('a', 'b', 'c'), Nil, Nil),
      (List('a', 'b'), List('c'), Nil),
      (List('a'), List('c'), List('b'))
    )

    assert(resultado == esperado)
  }

  test("Aplicar movimientos regresando vagones") {
    val estadoInicial = (List('p', 'q', 'r'), Nil, Nil)
    val movimientos = List(Uno(2), Uno(-1))
    val resultado = movimientosTren.aplicarMovimientos(estadoInicial, movimientos)

    val esperado = List(
      (List('p', 'q', 'r'), Nil, Nil),
      (List('p'), List('q', 'r'), Nil),
      (List('p', 'q'), List('r'), Nil)
    )

    assert(resultado == esperado)
  }

  test("Aplicar movimientos mezclados en dos vías") {
    val estadoInicial = (List('1', '2', '3', '4'), Nil, Nil)
    val movimientos = List(Uno(2), Dos(1), Dos(-1))
    val resultado = movimientosTren.aplicarMovimientos(estadoInicial, movimientos)

    val esperado = List(
      (List('1', '2', '3', '4'), Nil, Nil),
      (List('1', '2'), List('3', '4'), Nil),
      (List('1'), List('3', '4'), List('2')),
      (List('1', '2'), List('3', '4'), Nil)
    )

    assert(resultado == esperado)
  }

  test("Aplicar movimientos sin cambios") {
    val estadoInicial = (List('x', 'y'), Nil, Nil)
    val movimientos = List(Uno(0), Dos(0))
    val resultado = movimientosTren.aplicarMovimientos(estadoInicial, movimientos)

    val esperado = List(
      (List('x', 'y'), Nil, Nil),
      (List('x', 'y'), Nil, Nil),
      (List('x', 'y'), Nil, Nil)
    )

    assert(resultado == esperado)
  }

  test("Aplicar movimientos vacíos") {
    val estadoInicial = (List('a', 'b'), Nil, Nil)
    val movimientos = Nil
    val resultado = movimientosTren.aplicarMovimientos(estadoInicial, movimientos)

    val esperado = List((List('a', 'b'), Nil, Nil))

    assert(resultado == esperado)
  }


  test("Aplicar 10 movimientos en lista de tamaño 10") {
    val estado = (List.fill(10)("vagon"), Nil, Nil)
    val movimientos = List.fill(10)(Uno(1))
    val resultado = movimientosTren.aplicarMovimientos(estado, movimientos)
    assert(resultado.size == 11)
  }

  test("Aplicar 100 movimientos en lista de tamaño 100") {
    val estado = (List.fill(100)("vagon"), Nil, Nil)
    val movimientos = List.fill(100)(Uno(1))
    val resultado = movimientosTren.aplicarMovimientos(estado, movimientos)
    assert(resultado.size == 101)
  }

  test("Aplicar 500 movimientos en lista de tamaño 500") {
    val estado = (List.fill(500)("vagon"), Nil, Nil)
    val movimientos = List.fill(500)(Uno(1))
    val resultado = movimientosTren.aplicarMovimientos(estado, movimientos)
    assert(resultado.size == 501)
  }

  test("Aplicar 1000 movimientos en lista de tamaño 1000") {
    val estado = (List.fill(1000)("vagon"), Nil, Nil)
    val movimientos = List.fill(1000)(Uno(1))
    val resultado = movimientosTren.aplicarMovimientos(estado, movimientos)
    assert(resultado.size == 1001)
  }

}