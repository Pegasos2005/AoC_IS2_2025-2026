# reto06_TrashCompactor

Este sistema está diseñado siguiendo el estilo arquitectónico Modelo-Vista-Controlador (MVC), favoreciendo una separación clara y abstración del código, para un mejor mantenimiento.

Arquitectura:
-Modelo (Grid): Representa la parte central donde se definen los datos y la estructura de la información. Es independiente de la interfaz.
-Controlador (CalculatorController): Gestiona las interacciones, procesa las operaciones solicitando al modelo que cambie o a la vista que presente los datos.
-Vista (TotalPrinter): Se encarga de presentar los datos del modelo al usuario de forma comprensible.

Diseños Aplicados:
-Principio de Responsabilidad Única (SRP): Cada clase tiene una única responsabilidad. Por ejemplo, los parsers se limitan a transformar texto, mientras que los comandos se limitan al cálculo.
-Abstracción: Se utiliza la interfaz Reader para ocultar los detalles complejos de la entrada de archivos tras una interfaz simple. Actúa como un contrato entre el objeto y el usuario.
-Patrón Command: Las operaciones matemáticas se encapsulan como objetos (CalculateCommand), permitiendo parametrizar las solicitudes y separar al solicitante de la ejecución.
-Programación Funcional (Streams): Se emplea la API de Streams de Java 8 para procesar colecciones de datos de manera declarativa, mejorando la legibilidad mediante operaciones como filter, map y reduce.

Definición de Clases:
Main: Orquestador del sistema.
Grid: Contiene una matriz con los números y sus respectivos operadores (record).
FileInputReader: Implementa Reader, maneja el acceso físico para leer el sistema de archivos.
GridParser/GridParser2: Transforman el texto de input en el Grid necesario para resolver el problema.
CalculateCommand: Ejecuta la lógica de iterar sobre el Grid y coordinar las operaciones por columna.
MulOperation/SumOperation: Clases que contienen la lógica específica de reducción (multiplicación o suma) usando mapToLong para evitar sobrecarga de memoria.

