# AoC 2025-2026

Estos es una serie de recopilaciones de códigos necesaria para realizar los retos de navidad de la siguiente página: https://adventofcode.com
Han sido realizados para la asignatura de IS2 siguiendo la siguiente arquitectura:

Arquitectura:
-Modelo: Representa la parte central donde se definen los datos y la estructura de la información. Es independiente de la interfaz. Usa un TreeHash para optimizar la adición y búsqueda de nodos que son los rangos.
-Controlador: Gestiona las interacciones, procesa las operaciones solicitando al modelo que cambie o a la vista que presente los datos.
-Vista: Se encarga de presentar los datos del modelo al usuario de forma comprensible.

En la carpeta resources se encuentran los inputs.txt de cada día, y se pueden implementar los outputs
Queda pendiente para próximamente pulir algunos días, como el 8.2 y 10.2, además de la implementación de tests, pero todos los códigos son funcionales.

Por último, todos comparten en el paquete io, las clases Reader y InputFileReader, y el paquete view, lo único que cambia en este último es el texto que muestran. A pesar de ello, estas clases
están duplicadas en todos los retos permitiendo una personalización o modificación del paquete si es deseada
