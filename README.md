# Taller 3 - Fundamentos de Programación Funcional y Concurrente

**Universidad del Valle**  
**Escuela de Ingeniería de Sistemas y Computación**  
**Asignatura: Fundamentos de Programación Funcional y Concurrente**  
**Periodo académico: 2025-I**

---

## Integrantes del grupo

- **Sebastián Barco Espitia** - Código: 2380599
- **Santiago Montoya Mayor** - Código: 2380372
- **Juan Pablo Rodríguez Gutiérrez** - Código: 2380422

---

## Descripción general del taller

El presente taller aborda el problema de maniobras de trenes en una estación de maniobras, utilizando exclusivamente técnicas de programación funcional en el lenguaje Scala.  
El objetivo principal consistió en desarrollar funciones puras que permitieran aplicar movimientos, secuencias de movimientos y definir maniobras necesarias para transformar un tren inicial en uno deseado, bajo un modelo funcional estricto y sin utilizar estructuras imperativas como variables mutables, bucles o retornos explícitos.

Entre las principales actividades realizadas se destacan:

- Implementación de la función `aplicarMovimiento`, para efectuar movimientos individuales en un estado dado.
- Construcción de la función `aplicarMovimientos`, que aplica una lista de movimientos de manera funcional y acumulativa.
- Desarrollo de `definirManiobra`, empleando recursión de cola (`@tailrec`) para determinar la secuencia de movimientos requerida para alcanzar el tren objetivo.
- Elaboración de pruebas unitarias utilizando ScalaTest, cubriendo escenarios de distintos tamaños y complejidades.
- Análisis de tiempos de ejecución en escenarios de prueba de tamaño juguete, pequeño, mediano y grande, con el fin de verificar la eficiencia de las soluciones implementadas.

Todo el desarrollo respetó los principios de programación funcional, garantizando la inmutabilidad de datos y promoviendo el diseño de funciones puras.

---

## Resultados obtenidos

Durante la ejecución del taller se logró:

- Aplicar correctamente la transformación de estados mediante movimientos definidos.
- Construir maniobras funcionales que permiten reordenar trenes en cualquier configuración dada.
- Comprobar la eficiencia de las soluciones mediante mediciones de tiempo en el entorno Gradle, evidenciando tiempos de respuesta óptimos incluso en listas de hasta 1000 elementos.
- Validar la solidez del código a través de la implementación de pruebas unitarias variadas y sistemáticas.

---

## Conclusión general

El desarrollo de este taller fortaleció de manera significativa nuestras competencias en programación funcional, consolidando la comprensión de conceptos como la recursión de cola, el diseño de funciones puras, el uso de combinadores funcionales como `foldLeft`, y las expresiones `for`.

Además, nos permitió entender la importancia de construir software confiable, predecible y escalable, especialmente en contextos donde el tamaño de los datos o la complejidad de las operaciones puede crecer considerablemente.  
El manejo adecuado de la recursión y la estructuración funcional de los algoritmos garantizaron tanto la corrección de las soluciones como su eficiencia, evitando errores comunes como el desbordamiento de pila.

Finalmente, este ejercicio reafirmó el valor de las pruebas de software bien diseñadas como herramienta fundamental para asegurar la calidad y robustez del código, preparándonos para enfrentar con éxito desafíos de programación funcional de mayor envergadura en el ámbito académico y profesional.

---

