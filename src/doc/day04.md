# reto04_PrintDepart
Función:
Lee un archivo, referido como el espacio de un almacenamiento, en el que cada @ son rollos. Si cada @ es colindante a 3 @ más (incluyendo diagonales) este se considerará accesible. El siguiente código lee la cantidad de rollos (@) accesibles disponibles. Este ha sido
diseñado siguiendo principios SOLID, Zero-Allocation en rutas críticas y Arquitectura por Capas.

Clases:
-Main
-Reader: Procesamiento de archivos mediante Java Streams y NIO para minimizar la huella de memoria.
-Grid: Algoritmo de detección de "rollos accesibles" optimizado para recorrer matrices grandes sin generar basura en el Heap (Garbage Free) (No crea List ni Array cada segundo para borrarlos)
-Métodos inmutables: No utilizados, a parte del Grid, por la presencia de multiples búcles para recorrer Grid, pero no se descarta su implementación (como record Position) para facilitar el movimiento y lectura en el Grid.

src/main/java/software/RN/org
├── io
│   └── Reader.java          Input(Path), Output(List<String>) Mediante Stream
├── model
│   ├── Grid.java            # SFM(Input(List<String>), Output(Grid -> char[][]))
├── service
│   └── RollManager.java      # countAccessibleRolls(Input(Grid), Output(int))
└── Main.java                # Punto de entrada y orquestación
