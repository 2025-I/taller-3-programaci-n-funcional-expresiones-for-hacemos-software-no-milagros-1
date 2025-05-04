# 4. Argumentación formal y corrección de los algoritmos

##  Definiciones formales

Sea el estado del sistema un triplete:

*E = (P, U, D)*

Donde:
- *P* es la lista de vagones en la vía principal
- *U* es la lista de vagones en la vía uno
- *D* es la lista de vagones en la vía dos

Sea m ∈ Movimiento, donde:

- m = Uno(n) o m = Dos(n) con n ∈ ℤ
- Si n > 0, se mueven n vagones del final de P a U o D
- Si n < 0, se mueven |n| vagones desde U o D al final de P

La función de transición se define como:

math
aplicarMovimiento: (Estado, Movimiento) → Estado


Y satisface:

math
aplicarMovimiento((P, U, D), Uno(n)) =
\begin{cases}
(P', U' = L ++ U, D) & \text{si } n > 0 \\
(P ++ L, U', D) & \text{si } n < 0
\end{cases}


Análogamente para Dos(n) modificando D en lugar de U.

---

##  Composición de movimientos

Dado un conjunto de movimientos M = [m₁, m₂, ..., mₖ], la función:

math
aplicarMovimientos(E₀, M) = Eₖ


se define inductivamente:

math
aplicarMovimientos(E, []) = [E]
aplicarMovimientos(E, m::ms) = aplicarMovimientos(aplicarMovimiento(E, m), ms)


Esta definición es funcional, pura y determinista.

---

##  Correctitud de definirManiobra

Queremos demostrar que:

math
definirManiobra(P₀, P₁) = M  ⇒ aplicarMovimientos((P₀, [], []), M).last = (P₁, [], [])


###  Prueba por inducción estructural sobre P₁

*Caso base*:  
P₁ = []  
⇒ No hay más vagones por organizar. Entonces, maniobra = [] y el estado ya es correcto.

*Paso inductivo*:  
Supongamos que para un objetivo P₁ = [h₁, ..., hₙ] se construye una maniobra M₁ tal que:

math
aplicarMovimientos(E₀, M₁).last = ([h₁, ..., hₙ], [], [])


Queremos construir una maniobra M₂ para P₁' = [h₀] ++ P₁  
Se realiza una búsqueda funcional de h₀ en P, U, D y se mueve con uno o más pasos hasta quedar como head(P) = h₀. Luego se elimina de P y se aplica recursión.

Esto garantiza que en cada paso, el algoritmo reduce el tamaño del problema y conserva la invariancia:

math
P₁.head = P.head ⇒ progreso válido


Por lo tanto, por inducción, la función definirManiobra genera una secuencia correcta que transforma P₀ → P₁.

---

## Ejemplo de pila de llamados

Sea P₀ = [A, B, C], P₁ = [C, B, A]. Llamadas recursivas:

text
definirManiobra([A, B, C], [C, B, A])
↳ busca C → mueve a la cabeza
↳ define nuevo estado y llama con objetivo [B, A]
↳ busca B → mueve a la cabeza
↳ llama con objetivo [A]
↳ busca A → mueve a la cabeza
↳ llama con objetivo []
↳ devuelve maniobra acumulada


Con @tailrec, estas llamadas no consumen pila real adicional: el compilador optimiza la recursión.

---

##  Conclusiones

- Los algoritmos están definidos como funciones puras, deterministas y recursivas.
- Se ha demostrado inductivamente la correctitud de definirManiobra sobre la estructura del tren objetivo.
- Se cumple que al aplicar la maniobra generada se obtiene exactamente el tren deseado.
- Se utilizaron notaciones formales para representar estados y transiciones.
- La implementación en Scala refleja fielmente estas definiciones matemáticas.