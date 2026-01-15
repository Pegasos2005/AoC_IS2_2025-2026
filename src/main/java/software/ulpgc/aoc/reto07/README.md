# reto07_Laboratories

Este sistema está diseñado siguiendo el estilo arquitectónico Modelo-Vista-Controlador (MVC), favoreciendo una separación clara y abstración del código, para un mejor mantenimiento.

Arquitectura:
-Modelo: Representa la parte central donde se definen los datos y la estructura de la información. Es independiente de la interfaz. Usa un TreeHash para optimizar la adición y búsqueda de nodos que son los rangos.
-Controlador: Gestiona las interacciones, procesa las operaciones solicitando al modelo que cambie o a la vista que presente los datos.
-Vista: Se encarga de presentar los datos del modelo al usuario de forma comprensible.

Diseños Aplicados:
-Principio de Responsabilidad Única (SRP): Cada clase tiene una única responsabilidad. Por ejemplo, los parsers se limitan a transformar texto, mientras que los comandos se limitan al cálculo.
-Abstracción: Se utiliza la interfaz Reader para ocultar los detalles complejos de la entrada de archivos tras una interfaz simple. Actúa como un contrato entre el objeto y el usuario.
-Patrón Command: Las operaciones matemáticas se encapsulan como objetos, permitiendo parametrizar las solicitudes y separar al solicitante de la ejecución.
-Programación Funcional (Streams): Se emplea la API de Streams de Java 8 para procesar colecciones de datos de manera declarativa, mejorando la legibilidad mediante operaciones como filter, map y reduce.

Definición de Clases:
Main: Orquestador del sistema.
Position: Simula las coordenadas de cada punto del mapa, con sus funciones para desplazarse abajo, derecha e izquierda (record).
Grid: Simula el mapa y tienen sus funciones para escribir en él, imprimirlo, leer en él...
GridWriter: Escribe el mapa en un archivo, para ver el resultado.
FileInputReader: Implementa Reader, maneja el acceso físico para leer el sistema de archivos.
GridParser: Convierte las lineas leidas por Reader en una matriz para crear Grid.
SimulateBFS: Simula el recorrido de los rayos con un BFS.
SimulateDFS: Simula el recorrido de los rayos con un DFS e incorpora una memoria para no repetir un camino por el que ha pasado, guardando los rayos que se van a generar desde cada coordenada.
