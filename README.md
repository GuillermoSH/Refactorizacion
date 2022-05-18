<div align="justify">

# Refactorización

## ¿Cuál es el objetivo de la refactorización?

La refactorización siempre tiene el sencillo y claro propósito de mejorar el código. Con un código más efectivo, puede facilitarse la integración de nuevos elementos sin incurrir en errores nuevos. ___Además, cuanto más fácil les resulte a los programadores leer el código, más rápido se familiarizarán con él y podrán identificar y evitar los bugs de forma más eficiente. Otro objetivo de la refactorización es mejorar el análisis de errores y la necesidad de mantenimiento del software___. Poner a prueba el código ahorra esfuerzo a los programadores.

### ¿Qué fuentes de error corrige la refactorización?

Los métodos aplicados en la refactorización son tan variados como los errores que tratan de corregir. De manera general, la refactorización del código se guía por sus errores y va mostrando los pasos necesarios para acortar o eliminar procesos de corrección. Algunas de las fuentes de error que pueden corregirse mediante refactoring son las siguientes:

- __Estructuras complicadas o demasiado largas__: cadenas y bloques de comandos tan largos que la lógica interna del software se vuelve incomprensible para lectores externos.
- __Redundancias en el código__: los códigos poco claros suelen contener repeticiones que han de corregirse una a una durante el mantenimiento, por lo que consumen mucho tiempo y recursos.
- __Listas de parámetros demasiado largas__: los objetos no se asignan directamente a un método, sino que se indican sus atributos en una lista de parámetros.
- __Clases con demasiadas funciones__: clases con demasiadas funciones definidas como método, también llamadas god objects, que hacen que adaptar el software se vuelva casi imposible.
- __Clases con funciones insuficientes__: clases con tan pocas funciones definidas como método que se vuelven innecesarias.
- __Código demasiado general con casos especiales__: funciones con casos especiales demasiado específicos que apenas se usan y que, por lo tanto, dificultan la incorporación de ampliaciones necesarias.
- __Middle man__: una clase separada actúa como intermediaria entre los métodos y las distintas clases, en lugar de direccionar las solicitudes de los métodos directamente a una clase.
