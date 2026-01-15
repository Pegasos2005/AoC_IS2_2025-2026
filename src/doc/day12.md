# RN_D12.0_TreeFarm

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
ForestZone: Representación de los datos que describe el área de trabajo y sus requisitos de piezas.
TimberShape: Encapsula la lógica de los datos geométricos, incluyendo máscaras de bits y la generación de variaciones (rotaciones y simetrías).
ZoneSolver: Contiene la lógica de negocio principal, implementando un algoritmo de búsqueda exhaustiva para determinar si una zona es resoluble.
FarmController: Punto de contacto que traduce los datos brutos en objetos de dominio y orquesta los comandos de validación.
FileSourceReader: Implementación concreta de Reader que maneja el acceso físico al hardware mediante flujos de datos (Files.lines).
FarmOperation: Interfaz que define el contrato de comportamiento para las acciones de la granja.
ValidateZoneCommand: Comando concreto que ejecuta la validación de una zona específica delegando en el solver.