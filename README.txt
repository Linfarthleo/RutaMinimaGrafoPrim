# CalculadoraRutaMínimaEntreCiudades
# README

## CONTENIDOS DE ESTE DOCUMENTO
   
* Introducción
* Requerimientos
* Instalación
* Configuración
* Solución de problemas
* FAQ
* Mantenedores
* Como contribuir


## INTRODUCCIÓN

Este programa ofrece una solución simulada para encontrar la ruta más optima implementando una calculadora de rutas mínimas entre ciudades utilizando grafos no dirigidos con el algoritmo de Prim. Además, cuenta con funciones como: ingresar ciudades, seleccionar ciudades y conectar ciudades.

El programa utiliza listas para almacenar los países y sus ciudades, estas se encuentran en la clase Países, pero también se usan en el la Clase controlador a manera de auxiliares , el funcionamiento lógico principal viene relacionado con la creación de un grafo con su matriz de costos mínimos que es procesado por el algoritmo de Prim en la clase “AlgPrim”, este grafo se creó con el apoyo de la estructura de datos de una matriz, al finalizar se obtiene la forma en la que se debe conectar las ciudades para conseguir una ruta optima en cuento a distancias.

* Para una descripción completa, visite el artículo del proyecto:
https://epnecuador-my.sharepoint.com/:f:/g/personal/galo_asitimbaya_epn_edu_ec/EvGhvzi2r7pMuwmYUNi4VCYBsUV6AJY78beGAxKMh3UHGg?e=Z9yjNR 

* Para enviar cualquier reporte sobre errores, preguntas o sugerencias:
(galo.asitimbaya@epn.edu.ec, emilio.montalvo@epn.edu.ec, karla.vivas@epn.edu.ec)
  
## REQUERIMIENTOS

Este proyecto requiere lo siguiente:

* Windows 10 (https://www.microsoft.com/en-us/software-download/windows10)
* JDK 16.0.2 (https://www.oracle.com/java/technologies/downloads/)


## INSTALACIÓN
 
* No requiere instalación, dar clic derecho en el ejecutable y dar clic en Abrir. 


## CONFIGURACIÓN
 
* Configurar Smart Screen de Microsoft Defender para ejecutar la aplicación siguiendo los siguientes pasos:

- Dar clic en el botón Más información.

- Dar clic en el botón Ejecutar de todas formas.


## SOLUCIÓN DE PROBLEMAS

* Si el inicio no aparece, compruebe lo siguiente:

  - ¿Están activados los permisos de "SmartScreen de Windows Defender" y si se seleccionó "Ejecutar de todas formas"?

- ¿Está instalada la versión más reciente de Java, o como mínimo la versión 16.0.2?

* “Error: A JNI error has occurred, please check your installation …”

  - Para solucionar el error, sólo hay que ajustar las variables de entorno para Java.

  - Para ello, navega escribiendo "env" en la búsqueda de Windows y abre el elemento "Edición de las variables de entorno del sistema". En esta ventana haz clic en "Variables de entorno...".

  - Se abre la ventana "Variables de entorno". Allí seleccionas la variable "Path" en la ventana inferior y haces clic en "Edit...".

  - Allí buscas la línea donde se almacena la ruta de instalación de tu JDK. Por ejemplo, C:\NArchivos de Programa\NJava\jdk-13.0.1\bin.

  - Si no tiene esta entrada en su base de datos, puede añadirla haciendo clic en el botón "Nuevo". Si aún no ha instalado el JDK, puede hacerlo aquí.

  - Cuando haya encontrado la línea, haga clic en "Mover hacia arriba" hasta que la entrada esté en la parte superior de la lista. Listo.


## FAQ

Q: ¿Se puede desarrollar en sistemas operativos distintos a Windows?

A: Si, es posible desarrollar el proyecto en MacOs, de hecho, existe una rama en el repositorio de GitHub, la cual contiene las librerías que necesita el sistema operativo MacOs. 


## MANTENEDORES

Mantenedores actuales:

* Leonardo Asitimbaya (Linfarthleo) 
- galo.asitimbaya@epn.edu.ec 
- https://github.com/Linfarthleo

* Emilio Montalvo (EmilioMontalvo) 
- emilio.montalvo@epn.edu.ec
- https://github.com/EmilioMontalvo

* Karla Vivas (karlavv7) 
- karla.vivas@epn.edu.ec
- https://github.com/karlavv7


Este proyecto ha sido respaldado por:

* MSc. Mayra CARRION TORO
PROFESOR PRINCIPAL (ESCUELA POLITÉCNICA NACIONAL)
DOCENTE INVESTIGADOR
+593 2 2976300  ¦  Ext.: 4712
mayra.carrion@epn.edu.ec
fis.epn.edu.ec
Ladrón de Guevara E11-253 y Andalucía.              fisepn
Edificio de Sistemas, 2do Piso.                     @FIS_EPN
Laboratorio de Sistemas de Información Social 403.

Quito – Ecuador

## COMO CONTRIBUIR


* Para ser parte del proyecto y poder colaborar, se debe:

- Tener como objetivo mejorar el código, tratando de no dañar el actual código.

- Tener como mínimo conocimientos intermedios de programación en Java y GitHub.

- Se debe enviar un mensaje que solicite el permiso de colaborador, al correo: galo.asitimbaya@epn.edu.ec

* El proyecto se encuentra en un repositorio de GitHub, se lo puede encontrar en la siguiente ruta:

https://github.com/Linfarthleo/RutaMinimaGrafoPrim
