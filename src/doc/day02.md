# reto02_GiftShop

Este sistema está diseñado siguiendo el estilo arquitectónico Modelo-Vista-Controlador (MVC), favoreciendo una separación clara y abstración del código, para un mejor mantenimiento.

Arquitectura:
-Modelo (IdRange): Representa la parte central donde se definen los datos y la estructura de la información. Es independiente de la interfaz. Usa un TreeHash para optimizar la adición y búsqueda de nodos que son los rangos.
-Controlador (RangesController): Gestiona las interacciones, procesa las operaciones solicitando al modelo que cambie o a la vista que presente los datos.
-Vista (TotalPrinter): Se encarga de presentar los datos del modelo al usuario de forma comprensible.

Diseños Aplicados:
-Principio de Responsabilidad Única (SRP): Cada clase tiene una única responsabilidad. Por ejemplo, los parsers se limitan a transformar texto, mientras que los comandos se limitan al cálculo.
-Abstracción: Se utiliza la interfaz Reader para ocultar los detalles complejos de la entrada de archivos tras una interfaz simple. Actúa como un contrato entre el objeto y el usuario.
-Patrón Command: Las operaciones matemáticas se encapsulan como objetos, permitiendo parametrizar las solicitudes y separar al solicitante de la ejecución.
-Programación Funcional (Streams): Se emplea la API de Streams de Java 8 para procesar colecciones de datos de manera declarativa, mejorando la legibilidad mediante operaciones como filter, map y reduce.

Definición de Clases:
Main: Orquestador del sistema.
IdRange: Contiene los rangos de los productos frescos, para optimizar la búsqueda (record).
FileInputReader: Implementa Reader, maneja el acceso físico para leer el sistema de archivos.
FileParser: Transforman el texto de input en una lista de rangos necesario para crear el arbol de nodos.
CalvulateSumCommand: Itera sobre los números dentro de cada rango, con la funcion stream de IdRange, y con IdValidator, revisa si es válido y va contando todos los válidos.
IdValidator: Contiene el algoritmo/fórmula que se a va a ejecutar para ver si el algoritmo es válido.
