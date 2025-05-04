# 1. Proceso de ejecución de los algoritmos

## aplicarMovimiento

- Aplica un único movimiento (Uno(n) o Dos(n)) sobre un estado compuesto por tres listas: (principal, uno, dos).
- Utiliza pattern matching para distinguir el tipo de movimiento (Uno o Dos) y su dirección (positiva o negativa).
- Si n > 0, mueve n vagones desde el principal hacia el trayecto auxiliar (uno o dos).
- Si n < 0, mueve n vagones desde el trayecto auxiliar de regreso al principal.
- Si n == 0, no hay ningún efecto sobre el estado.

---

## aplicarMovimientos

- Aplica una secuencia de movimientos (Maniobra) sobre un estado inicial.
- Se implementa con una función auxiliar recursiva de cola (@tailrec) en lugar de foldLeft, para seguir un estilo funcional más explícito y mantener claridad en el flujo.
- El estado se actualiza de forma funcional en cada paso, construyendo una lista de estados intermedios hasta completar todos los movimientos.
- No se utiliza mutabilidad, ciclos imperativos ni efectos secundarios.

---

## definirManiobra

- Construye paso a paso una lista de movimientos que transforman un tren t1 en un tren objetivo t2.
- Utiliza recursión de cola (@tailrec) para garantizar eficiencia y evitar desbordamientos de pila.
- En cada llamada:
    - Compara el primer elemento del principal con el primero del objetivo.
    - Si coincide, lo avanza.
    - Si no coincide, busca el elemento objetivo en los tres trayectos (principal, uno, dos) utilizando expresiones for con zipWithIndex.
    - Aplica el movimiento correspondiente para acercar el vagón deseado al frente del principal.
- El proceso continúa hasta que el principal coincide completamente con el tren objetivo t2, dejando los trayectos auxiliares vacíos.

---