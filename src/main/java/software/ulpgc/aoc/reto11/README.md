# reto11_Reactor

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
Main: Orquestadores del sistema que inician la lectura, el controlador y la salida visual.
ReactorNetwork: Clase del modelo que representa el ecosistema de conexiones y gestiona la lógica de conteo de rutas.
ReactorController: Punto de contacto que traduce los datos de entrada en acciones del modelo y comandos.
PathCommand: Interfaz que define el contrato de ejecución para cualquier algoritmo de cálculo de rutas.
DirectPathCalculation: Comando que ejecuta la lógica para encontrar rutas directas entre dos puntos.
WaypointPathCalculation: Comando avanzado que orquesta múltiples consultas al modelo para calcular rutas que pasen obligatoriamente por hitos intermedios.
FileInputReader: Implementación de Reader que maneja el acceso físico para leer el sistema de archivos de manera desacoplada.
ReactorPrinter: Componente de la vista que muestra los resultados finales al usuario.
