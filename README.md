<div align="justify">

# Refactorización

## Terminología

El concepto de refactorización – una de las traducciones más habituales del inglés __refactoring__, que otros traducen como refabricación – tiene que ver con el cambio de un diseño una vez que se desarrolló una funcionalidad y la misma ya está codificada.
La idea de la refactorización es mejorar el diseño de parte de una aplicación que ya está funcionando. Por lo tanto, un buen término sería rediseño, pero lamentablemente no es muy usual.
El problema con las refactorizaciones es que son riesgosas, ya que estamos cambiando código que sabemos que funciona por otro que – aunque presumimos que va a ser de mejor calidad – no sabemos si funcionará.

Para ___permitir refactorizaciones más seguras y con menos estrés___, una buena táctica es trabajar con __pruebas unitarias__ automatizadas, escritas __antes de refactorizar__. Es decir, no importa si hemos escrito o no pruebas unitarias a nuestro código en funcionamiento. ___Pero si vamos a refactorizar, debemos escribirlas antes___.
Y – por supuesto – correrlas después para asegurarnos que nuestro programa sigue funcionando.

## Cuando el código fuente decae: el código espagueti

Antes que nada, es importante entender que ___un código puede degenerar a lo largo del tiempo y convertirse en un infame código espagueti___. Ya sea por falta de tiempo, por falta de experiencia o por directrices poco claras, las órdenes innecesariamente complejas en la programación del código acaban obstaculizando su funcionalidad. Cuanto más rápido y complejo sea el ámbito de aplicación de un código, más se erosionará.
___El término código espagueti hace referencia a códigos fuente confusos y de difícil lectura___, cuya estructura es difícil de comprender para los programadores. Algunos ejemplos típicos de elementos que complican el código son las órdenes de salto ___(GOTO) redundantes, que indican al programa que vaya saltando de un sitio a otro en el código; los bucles for/while y los comandos if___.
Concretamente, los proyectos en los que trabajan muchos desarrolladores suelen generar un código poco legible. Si un código que ya de por sí presentaba ciertas imperfecciones pasa por muchas manos, es difícil evitar que se encadenen modificaciones a modo de parche y que, finalmente, se requiera una cara revisión o review del código para corregirlo. En el peor de los casos, el código espagueti puede poner en peligro todo el proceso de desarrollo del software, llegando a un punto en el que ni siquiera la refactorización puede resolver el problema.
Los llamados code smells y el code rot(es decir, los defectos y la erosión del software) no tienen por qué ser tan preocupantes. Con el paso del tiempo, si un código contiene muchos elementos innecesarios, puede empezar a apestar, por así decirlo. Las secciones poco claras de la estructura empeoran cada vez que un programador nuevo se pone a trabajarlas o amplía el código. Es por tanto necesario realizar un refactoring en cuanto aparezcan los primeros code smells, ya que si no el código seguirá erosionándose y perderá su funcionalidad a causa del code rot (el proceso de putrefacción, traducido literalmente).

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

## Recuerda siempre

  <div align="center">

  <img src="https://miro.medium.com/max/1400/1*RieLfIqg9CGCVmENxDuByA.png" width="400px" >

  </div>

## Referencias
- [Refactorización](https://cysingsoft.wordpress.com/un-ejercicio-de-refactorizacion/)

</div>
