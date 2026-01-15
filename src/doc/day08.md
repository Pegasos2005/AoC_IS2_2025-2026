# reto08_Playground

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
Main: Orquestador del sistema que coordina la lectura de datos, el controlador y la impresión del resultado.
Box: Record que representa un punto en el espacio 3D (x, y, z) con su identificador y funciones para calcular distancias al cuadrado hacia otros puntos.
Edge: Record que representa una conexión potencial entre dos cajas, implementando la interfaz Comparable para ser gestionado en colas de prioridad por distancia.
Conections: Estructura de datos que almacena los arreglos de "padres" y "tamaños" necesarios para la lógica de conjuntos disjuntos (Union-Find).
CircuitController: Controlador que gestiona el ciclo de vida del cálculo de circuitos, desde la creación de conexiones iniciales hasta la obtención del producto de los grupos más grandes.
FileInputReader: Implementación de la interfaz Reader que maneja el acceso físico para leer el sistema de archivos.
CreateConectionsCommand: Inicializa la estructura de datos Conections, asignando a cada caja como su propio representante inicial.
CalculateConectionsCommand: Calcula todas las posibles aristas entre las cajas y las organiza en una PriorityQueue según su distancia.
UniteConectionsCommand: Ejecuta la lógica de unión entre dos puntos utilizando Path Compression y Union by Size para mantener los árboles balanceados.
ThreeLargestCircuitsCommand: Utiliza Streams para identificar los tres grupos (circuitos) con mayor número de elementos y devolver su producto.
