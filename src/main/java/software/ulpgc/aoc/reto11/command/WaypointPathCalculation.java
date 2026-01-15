package software.ulpgc.aoc.reto11.command;

import software.ulpgc.aoc.reto11.model.ReactorNetwork;

// Comando para Parte 2: Inicio -> Hito1 -> Hito2 -> Fin
public record WaypointPathCalculation(String start, String end, String mid1, String mid2) implements PathCommand {
    @Override
    public long execute(ReactorNetwork network) {
        // La lógica de negocio compuesta reside aquí o en el servicio,
        // pero siguiendo el patrón Command, el comando orquesta al modelo.

        // Ruta 1: Start -> Mid1 -> Mid2 -> End
        long segmentA = network.countRoutes(start, mid1);
        long segmentB = network.countRoutes(mid1, mid2);
        long segmentC = network.countRoutes(mid2, end);
        long total1 = segmentA * segmentB * segmentC;

        // Ruta 2: Start -> Mid2 -> Mid1 -> End (Por si el orden es inverso)
        long segmentX = network.countRoutes(start, mid2);
        long segmentY = network.countRoutes(mid2, mid1);
        long segmentZ = network.countRoutes(mid1, end);
        long total2 = segmentX * segmentY * segmentZ;

        // En un grafo dirigido acíclico (DAG), una de las dos será 0.
        return total1 + total2;
    }
}