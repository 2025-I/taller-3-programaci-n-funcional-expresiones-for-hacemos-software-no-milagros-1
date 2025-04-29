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
El objetivo principal consistió en desarrollar funciones puras que permitieran aplicar movimientos individuales, secuencias de movimientos, y definir maniobras necesarias para transformar un tren inicial en uno deseado, bajo un modelo funcional estricto y sin utilizar estructuras imperativas como variables mutables, bucles o retornos explícitos.

Se utilizaron expresiones `for` para recorrer listas de forma funcional, respetando el paradigma de inmutabilidad y composición de funciones.

Todo el desarrollo respetó los principios de programación funcional, garantizando la inmutabilidad de datos y promoviendo el diseño de funciones puras.

---

## Resultados obtenidos

Durante la ejecución del taller se logró:

- Aplicar correctamente la transformación de estados mediante movimientos definidos.
- Construir maniobras funcionales que permiten reordenar trenes en cualquier configuración dada.
- Implementar expresiones `for` y combinadores como `foldLeft` para recorrer listas de manera funcional.
- Comprobar la eficiencia de las soluciones mediante mediciones de tiempo en el entorno Gradle, evidenciando tiempos de respuesta óptimos incluso en listas de hasta 1000 elementos.
- Validar la solidez del código a través de la implementación de pruebas unitarias variadas y sistemáticas.

---

## Informe de proceso

El proceso de ejecución de los algoritmos se basó en:

- Uso de **expresiones `for`** para recorrer listas de movimientos y construir secuencias funcionalmente.
- Implementación de funciones puras sin variables mutables (`var`), ni ciclos `while` o `for` imperativos.
- Empleo de **recursión de cola** (`@tailrec`) en `definirManiobra` para evitar desbordamientos de pila, permitiendo trabajar con listas de tamaño grande sin errores de StackOverflow.
- Manejo controlado del **estado de la pila de llamadas** en cada recursión, asegurando que cada nueva llamada consume la misma cantidad de memoria gracias a la optimización de tail call.

---

## Informe de corrección

Se validó que todas las funciones implementadas cumplen con:

- Correctitud funcional: las funciones transforman los estados conforme a las reglas definidas para los movimientos `Uno(n)` y `Dos(n)`.
- Programación funcional pura: no se utilizan variables mutables, bucles imperativos, ni instrucciones de retorno explícito.
- Recursión segura: el uso de `@tailrec` garantiza que las funciones no provoquen desbordamiento de pila para entradas grandes.
- Pruebas unitarias exitosas: todos los casos de prueba ejecutados arrojan los resultados esperados para diferentes tamaños de entrada.

De esta manera, los algoritmos son correctos tanto en su comportamiento como en su implementación funcional.

---

## Pruebas de software

Se implementaron pruebas unitarias utilizando ScalaTest, cubriendo los siguientes tamaños:

- **Pruebas de juguete**: 10 vagones y movimientos.
- **Pruebas pequeñas**: 100 vagones y movimientos.
- **Pruebas medianas**: 500 vagones y movimientos.
- **Pruebas grandes**: 1000 vagones y movimientos.

Cada función (`aplicarMovimiento`, `aplicarMovimientos`, `definirManiobra`) cuenta con al menos 5 casos de prueba diferentes, cubriendo casos normales, extremos y de error.  
La eficiencia de ejecución fue validada utilizando el reporte de tiempos de Gradle.

---

## Conclusión general

El desarrollo de este taller fortaleció de manera significativa nuestras competencias en programación funcional, consolidando la comprensión de conceptos como la recursión de cola, el diseño de funciones puras, el uso de combinadores funcionales como `foldLeft` y las expresiones `for`.

Además, nos permitió entender la importancia de construir software confiable, predecible y escalable, especialmente en contextos donde el tamaño de los datos o la complejidad de las operaciones puede crecer considerablemente.  
El manejo adecuado de la recursión y la estructuración funcional de los algoritmos garantizó tanto la corrección de las soluciones como su eficiencia, evitando errores comunes como el desbordamiento de pila.

Finalmente, este ejercicio reafirmó el valor de las pruebas de software bien diseñadas como herramienta fundamental para asegurar la calidad y robustez del código, preparándonos para enfrentar con éxito desafíos de programación funcional de mayor envergadura en el ámbito académico y profesional.

---
