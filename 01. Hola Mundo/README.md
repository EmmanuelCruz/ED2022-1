# Hola Mundo en ANT
## Emmanuel Cruz Hernández

----

## Sobre ANT

Apache’s Another Neat Tool, mejor conocido como ANT, es una herramienta que nos ayuda a compilar, limpiar los ficheros de instalación e incluso instalar software hecho con Java.

Los comandos básicos para manejar un proyecto con ANT se encuentran definidos en el archivo _build.xml_. Algunos de estos comandos son los siguientes:

* _ant build_
	Crea todos los archivos con extensión _.class_ a partir del código fuente, los archivos con extensión _.java_
* _ant jar_
	Genera un archivo ejecutable para el proyecto con extensión _.jar_
* _ant run_
	Ejecuta el proyecto a partir del ejecutable JAR generado.
* _ant clean_
	Limpia el proyecto, eliminando el directorio _build_ que contiene los archivos _.class_ y el _jar_.
* _ant doc_
	Genera la documentación del proyecto