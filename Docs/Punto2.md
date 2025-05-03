# 2. Diseño de funciones recursivas y uso de programación funcional

- Todas las funciones son puras: no modifican datos mutables ni usan var, while o return.
- definirManiobra utiliza recursión de cola con @tailrec para evitar desbordamientos de pila.
- Cada llamada recursiva resuelve un pequeño subproblema más simple que el anterior.
- Se utilizan expresiones for funcionales y recursión de cola en lugar de combinadores como foldLeft, priorizando claridad y control del flujo.
- Se aplican expresiones for donde es necesario para mantener la claridad y funcionalidad.
- El diseño garantiza eficiencia, claridad y escalabilidad en los algoritmos.

---
