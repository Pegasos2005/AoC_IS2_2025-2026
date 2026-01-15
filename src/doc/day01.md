# reto01_SecretEntrance

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
SafeDial: Simula el Dial, sin salir del margen de 0-99 y tiene funciones para contabilizar las veces que pasa por 0 (record).
FileInputReader: Implementa Reader, maneja el acceso físico para leer el sistema de archivos.
RotationCommand: Interfaz que manda a Dial a moverse en el sentido indicado, según la clase en la que haya sido implementada.
DialController: Gestiona que command será llamado e itera sobre cada linea del input.