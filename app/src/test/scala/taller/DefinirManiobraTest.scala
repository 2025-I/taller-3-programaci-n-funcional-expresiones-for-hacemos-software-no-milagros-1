package taller

import org.scalatest.funsuite.AnyFunSuite

class DefinirManiobraTest extends AnyFunSuite {

  val movimientosTren = new MovimientosTren()

  test("Definir maniobra sencilla de cambio de orden") {
    val trenInicial = List('a', 'b', 'c')
    val trenDeseado = List('c', 'b', 'a')
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)

    assert(maniobra.nonEmpty)
  }

  test("Definir maniobra de tren ya ordenado") {
    val trenInicial = List('x', 'y', 'z')
    val trenDeseado = List('x', 'y', 'z')
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)

    assert(maniobra.isEmpty)
  }

  test("Definir maniobra con movimiento entre vías") {
    val trenInicial = List('1', '2', '3')
    val trenDeseado = List('2', '1', '3')
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)

    assert(maniobra.nonEmpty)
  }

  test("Definir maniobra con solo un vagón") {
    val trenInicial = List('m')
    val trenDeseado = List('m')
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)

    assert(maniobra.isEmpty)
  }

  test("Definir maniobra con muchos vagones") {
    val trenInicial = List('a', 'b', 'c', 'd', 'e')
    val trenDeseado = List('e', 'd', 'c', 'b', 'a')
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)

    assert(maniobra.nonEmpty)
  }

  test("Definir maniobra para tren de 10 vagones") {
    val trenInicial = (1 to 10).toList
    val trenDeseado = trenInicial.reverse
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)
    assert(maniobra.nonEmpty)
  }

  test("Definir maniobra para tren de 100 vagones") {
    val trenInicial = (1 to 100).toList
    val trenDeseado = trenInicial.reverse
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)
    assert(maniobra.nonEmpty)
  }

  test("Definir maniobra para tren de 500 vagones") {
    val trenInicial = (1 to 500).toList
    val trenDeseado = trenInicial.reverse
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)
    assert(maniobra.nonEmpty)
  }

  test("Definir maniobra para tren de 1000 vagones") {
    val trenInicial = (1 to 1000).toList
    val trenDeseado = trenInicial.reverse
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)
    assert(maniobra.nonEmpty)
  }
  test("Definir maniobra con símbolos especiales") {
    val trenInicial = List('@', '#', '$', '%')
    val trenDeseado = List('%', '$', '#', '@')
    val maniobra = movimientosTren.definirManiobra(trenInicial, trenDeseado)
    assert(maniobra.nonEmpty)
  }

}