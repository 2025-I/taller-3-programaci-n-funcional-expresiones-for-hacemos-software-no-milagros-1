# 3. Ejecución del proceso, pila de llamados y pruebas de software

## ✔ Proceso de ejecución de las funciones

###  1. aplicarMovimiento

Esta función recibe un estado (principal, uno, dos) y un movimiento Uno(n) o Dos(n). Dependiendo del signo de n, transfiere elementos de una vía a otra.

*Ejemplo paso a paso:*
  
scala
Estado inicial:
principal = List(1, 2, 3, 4)
uno = List()
dos = List()

Movimiento: Uno(2)

Paso 1: Se toman los últimos 2 vagones del principal → List(3, 4)
Paso 2: Se mueven a la vía uno
Resultado:
principal = List(1, 2)
uno = List(3, 4)
dos = List()



---

### 2. aplicarMovimientos

Aplica una lista de movimientos secuenciales al estado, uno por uno, acumulando los nuevos estados.

*Ejemplo:*

scala
movimientos = List(Uno(2), Uno(-1), Dos(1))

Cada paso:
- Uno(2) → mueve 2 del principal a uno
- Uno(-1) → devuelve 1 de uno a principal
- Dos(1) → mueve 1 del principal a dos


---

### 3. definirManiobra

Recorre el estado actual para construir la lista de movimientos necesarios para transformar t1 en t2.

*Ejemplo paso a paso:*

scala
t1 = List(A, B, C)
t2 = List(C, B, A)

1. Se busca C en principal → moverlo a uno o dos → reordenar
2. Se busca B → idem
3. Se busca A


---
## Estado de la pila de llamados

La función definirManiobra usa recursión con cola (@tailrec), lo que evita crecimiento excesivo de pila.

*Ejemplo conceptual del stack (sin @tailrec):*


aux([C, B, A], [], estado0)
↳ aux([B, A], [mov1], estado1)
↳ aux([A], [mov1, mov2], estado2)
↳ aux([], [mov1, mov2, mov3], estado3)


Con @tailrec, el compilador optimiza este stack en una sola llamada activa.

---

##  Pruebas de software

Las pruebas se realizaron con ScalaTest y se diseñaron con los siguientes criterios:

- *Funciones cubiertas:*
  - aplicarMovimiento: 6 casos
  - aplicarMovimientos: 5 casos
  - definirManiobra: 7 casos

- *Tipos de prueba:*
  - Casos normales: listas pequeñas con movimientos válidos
  - Casos límite: listas vacías, n=0
  - Casos de error: más movimientos que elementos, estados inconsistentes

---

##  Pruebas por tamaños

| Escenario | Descripción |
|----------|-------------|
| Juguete | 10 vagones, 10 movimientos |
| Pequeño | 100 vagones, 100 movimientos |
| Mediano | 500 vagones, 500 movimientos |
| Grande | 1000 vagones, 1000 movimientos |

---

## 🧠 Conclusiones

- Las funciones están diseñadas para ser puras, recursivas y eficientes.
- Se evita el desbordamiento de pila mediante @tailrec.
- La lógica es escalable y se comporta correctamente incluso con 1000 elementos.
- La estrategia funcional facilita la lectura, pruebas y mantenimiento del código.
