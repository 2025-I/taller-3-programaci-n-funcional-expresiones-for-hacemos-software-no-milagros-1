# 4. Conclusiones y tiempos de ejecución

- Se midieron los tiempos de ejecución usando los reportes generados en /build/reports/tests/test/index.html.
- Resultados observados:
    - Para tamaños juguete y pequeños (<500 elementos), los tiempos son menores a 1 ms (despreciables).
    - Para tamaños medianos (500) y grandes (1000), el tiempo de ejecución aumenta, pero sigue siendo manejable.
- El algoritmo mantiene un buen rendimiento gracias a la recursión de cola y el enfoque funcional puro.
- Se concluye que:
    - El proceso de maniobras es correcto y eficiente para cualquier tamaño de entrada estándar.
    - Para escenarios de altísima carga (listas de más de 10,000 elementos), se recomienda usar estructuras de datos perezosas como LazyList.
    - La programación funcional pura permitió construir soluciones escalables, predecibles y fáciles de mantener.