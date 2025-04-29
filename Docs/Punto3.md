# 3. Generación de pruebas de software

- Se diseñaron pruebas unitarias utilizando ScalaTest.
- Cada función (aplicarMovimiento, aplicarMovimientos, definirManiobra) cuenta con al menos 5 casos de prueba diferentes.
- Se cubren distintos tipos de casos:
    - Casos normales (movimientos esperados).
    - Casos extremos (listas vacías, movimientos con n = 0).
    - Casos de error o entradas inesperadas (más movimientos que vagones).
- Pruebas organizadas por tamaños:
    - Juguete (10 vagones y movimientos).
    - Pequeño (100 vagones y movimientos).
    - Mediano (500 vagones y movimientos).
    - Grande (1000 vagones y movimientos).
- Se garantiza que no ocurra desbordamiento de pila gracias al uso de recursión de cola.

---
