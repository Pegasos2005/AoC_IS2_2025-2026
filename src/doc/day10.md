# reto10_Factory

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
Main: Orquestador del sistema que inicia la lectura del archivo, invoca al controlador y delega la salida a la vista
MachineLights: Record que almacena la máscara de bits de la posición objetivo y las máscaras correspondientes a cada botón disponible
MachineVolts: Record que contiene los objetivos de voltaje y la lista de índices de contadores que afecta cada botón
MachineController: Controlador que actúa como punto de entrada para las funciones de encendido y regulación
FileInputAdapter: Implementa la interfaz Reader y maneja el acceso físico para leer líneas del sistema de archivos mediante Files.lines
MachineLigthsParser: Analiza líneas de texto para extraer objetivos de luces representados por símbolos y botones representados por índices
MachineVoltParser: Utiliza patrones regex para extraer objetivos de voltaje y la configuración de botones desde el archivo de recursos
InitializationCommand: Resuelve el número mínimo de pulsaciones para encender luces probando todas las combinaciones posibles 2^n mediante operaciones XOR de máscaras
VoltRegulerCommand: Implementa un algoritmo de búsqueda con retroceso (backtracking) y poda por alcanzabilidad para encontrar la configuración óptima de voltajes
LightsCommand: Interfaz que define el contrato de ejecución para los comandos relacionados con la iluminación de las máquinas.
