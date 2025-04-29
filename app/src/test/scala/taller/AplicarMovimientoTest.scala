package taller

import org.scalatest.funsuite.AnyFunSuite

class AplicarMovimientoTest extends AnyFunSuite {

  val movimientosTren = new MovimientosTren()

  test("Mover 2 vagones de principal a uno usando Uno(2)") {
    val estadoInicial = (List('a', 'b', 'c', 'd'), Nil, Nil)
    val estadoEsperado = (List('a', 'b'), List('c', 'd'), Nil)
    assert(movimientosTren.aplicarMovimiento(estadoInicial, Uno(2)) == estadoEsperado)
  }

  test("Mover 1 vagón de principal a dos usando Dos(1)") {
    val estadoInicial = (List('x', 'y'), Nil, Nil)
    val estadoEsperado = (List('x'), Nil, List('y'))
    assert(movimientosTren.aplicarMovimiento(estadoInicial, Dos(1)) == estadoEsperado)
  }

  test("Regresar 1 vagón de uno a principal usando Uno(-1)") {
    val estadoInicial = (List('a'), List('b', 'c'), Nil)
    val estadoEsperado = (List('a', 'b'), List('c'), Nil)
    assert(movimientosTren.aplicarMovimiento(estadoInicial, Uno(-1)) == estadoEsperado)
  }

  test("Regresar 2 vagones de dos a principal usando Dos(-2)") {
    val estadoInicial = (List('m'), Nil, List('n', 'o'))
    val estadoEsperado = (List('m', 'n', 'o'), Nil, List())
    assert(movimientosTren.aplicarMovimiento(estadoInicial, Dos(-2)) == estadoEsperado)
  }

  test("No hacer nada con Uno(0)") {
    val estadoInicial = (List('x', 'y', 'z'), Nil, Nil)
    assert(movimientosTren.aplicarMovimiento(estadoInicial, Uno(0)) == estadoInicial)
  }

  test("Mover 1 vagón de lista de tamaño 10") {
    val estado = (List.fill(10)("vagon"), Nil, Nil)
    val resultado = movimientosTren.aplicarMovimiento(estado, Uno(1))
    assert(resultado._2.size == 1)
  }


  test("Mover 10 vagones de lista de tamaño 100") {
    val estado = (List.fill(100)("vagon"), Nil, Nil)
    val resultado = movimientosTren.aplicarMovimiento(estado, Uno(10))
    assert(resultado._2.size == 10)
  }

  test("Mover 50 vagones de lista de tamaño 500") {
    val estado = (List.fill(500)("vagon"), Nil, Nil)
    val resultado = movimientosTren.aplicarMovimiento(estado, Uno(50))
    assert(resultado._2.size == 50)
  }

  test("Mover 100 vagones de lista de tamaño 1000") {
    val estado = (List.fill(1000)("vagon"), Nil, Nil)
    val resultado = movimientosTren.aplicarMovimiento(estado, Uno(100))
    assert(resultado._2.size == 100)
  }


}