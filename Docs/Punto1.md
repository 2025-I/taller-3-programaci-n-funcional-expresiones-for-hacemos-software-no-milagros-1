# 1. Proceso de ejecución de los algoritmos

## aplicarMovimiento
- Aplica un único movimiento (Uno o Dos) sobre un estado (principal, uno, dos).
- Utiliza un patrón match-case para distinguir el tipo de movimiento y su dirección.
- Si n > 0, mueve n vagones del trayecto "principal" al auxiliar ("uno" o "dos").
- Si n < 0, mueve n vagones del trayecto auxiliar de regreso al "principal".
- Si n == 0, no hay ningún efecto sobre el estado.

## aplicarMovimientos
- Usa foldLeft para aplicar una lista de movimientos sobre un estado inicial.
- Alternativamente, puede usarse una función auxiliar con recursión de cola (@tailrec).
- El estado se actualiza funcionalmente en cada paso.
- No hay recursión explícita sobre las listas.

## definirManiobra
- Usa recursión de cola (@tailrec) para construir la lista de movimientos paso a paso.
- Cada llamada busca mover un vagón a su posición correcta en el trayecto principal.
- Se avanza de forma controlada hasta formar el tren deseado.
- Los trayectos auxiliares quedan vacíos al final del proceso.

---
