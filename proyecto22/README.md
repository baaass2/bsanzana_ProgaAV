# RACE SIMULATOR TO LEARN OOP(Object-oriented programming).
Con el objetivo de crear el concepto de carrera, a semejandoze a la realidad y así poder construir un código orientado a objetos, se ha llevado a cabo, el proyecto,
que se define como, un simulador de una carrera que se le agregan naves y a estas se le componen accesorios (alas, motor y un odómetro), a través de un método aleatorio
las naves tienden a ser diferentes, ya que existen materiales de los cuales estan hecho los accesorios, dependiendo de lo anterior, es que una nave puede ser más
rapido o más lenta, y así corren por una pista que es parte de la carrera hasta llegar a los 1000 km.

El proyecto esta alojado en el siguente repositorio:
https://github.com/baaass2/bsanzana_ProgaAV/tree/master/proyecto22.
Ahì se encuentra la ùltima actualizaciòn del proyecto.

### Pre-requisitos.
Tener la versión de java 11 o superior.
java-11-openjdk-amd64

### Instalación.
 Tener algun software (IDE) que permita correr archivos.java, se a conseja la IDE utlizada en este proyecto, Eclipse.

### Anàlisis del Proyecto.
El programa consiste en una clase Main que efectua el constructor de la clase Carrera, en este constructor, sé llama el método ensamblarNaves, el cual crean objetos
tipo Nave y se le da valores a los atributos determinados, luego se presentan las naves con sus correspondientes accesorios, y se da comienzo a la carrera, el primero en
completar 1000 km recorridos o más (atributo (largoPista) del objeto Pista que se compone en la carrera), es el ganador.
A través que transcurre la carrera existen los atributos de los accesorios que influyen en la velocidad de la nave, siendo la degradacion y salud de los accesorios, 
estos se degradan mientras más velocidad tenga la nave, existe un valor arbitrario, en el que, si se encuentra un accesorio que es menor o igual a ese valor, la nave 
se derige a la ambulancia (objeto que se compone en la carrera), la ambulancia repara el accesorio dañado, pero se entiende, que pierde 5 segundos la nave, y 
además la velocidad es valorazida nuevamente, dependiendo el combustible que se le haya dado a la nave. Y así es como interractuan las Naves con sus atributos y 
accesorios (objetos que componen la nave).

## Construido con.
Se mencionarà las herramientas usadas, y la funciòn en ESTE proyecto.

* [JAVA] - Lenguaje usado para el proyecto, versión java-11-openjdk-amd64.
* [Eclipse] - IDE que facilitó la construcción del código. 
    
## Autores.

* Benjamìn Adolfo Sanzana Silva [baaass2](https://github.com/baaass2/bsanzana_ProgaAV)

