# TPOO2_Grupo15
Trabajo Práctico de la catedra de Orientación a Objetos 2 de la Universidad Nacional de Lanús

Grupo 15
Miembros de este grupo:
 * Avila, Brian
 * Casco, Tomas Andres
 * Romero, Gabriel Omar
 * Vega, Ignacio David

Clases realizados:
 * Personal -> Cocinero y Cajero / Vega, Ignacio David
 * Festival / Avila, Brian

Importante:
  * Para poder ejecutar el código, es necesario tener Java 17.
  * Asegurarse que esté cargado las librerias correctamente.

  * Para compilar es necesario crear la base de datos con el comando: create database bd_tp_oo2;
  
  * Paso 1: en la carpeta raiz ejecutar este comando:
      javac -cp "lib/*;." -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
  
  * Paso 2 luego ejecutar este comando:
      Copy-Item hibernate.cfg.xml out\
      Copy-Item -Recurse src\mapeos out\

  * Paso 3 por ultimo ejecutar este comando para el test de conexion:
      java -cp "out;lib/*;." test.testConexion
