# reto09_MovieTheater

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
Main: Orquestador del sistema encargado de inicializar los componentes de IO, el controlador y la vista.
Point: Registro (record) que representa una coordenada esencial (x, y) en el espacio.
PointSpace: Clase del modelo que almacena la colección de puntos y encapsula la lógica geométrica de inclusión y colisión de paredes.
TheaterController: Controlador principal que coordina la ejecución de comandos para calcular áreas máximas válidas.
Reader: Interfaz que actúa como contrato para la lectura de datos, asegurando un bajo acoplamiento.
FileInputAdapter: Adaptador que implementa Reader para manejar el acceso físico al sistema de archivos.
SpaceParser: Clase especializada en transformar las líneas de texto bruto en el objeto de dominio PointSpace.
AreaCommand: Interfaz del patrón Command que define la operación de ejecución para cálculos de área.
FindMaxAreaCommand: Comando concreto que calcula el área máxima simple entre cualquier par de puntos.
FindMaxValidAreaCommand: Comando que calcula el área máxima considerando restricciones geométricas de paredes, utilizando procesamiento en paralelo para mayor eficiencia.
AreaPrinter: Componente de la vista que muestra el resultado final al usuario.
