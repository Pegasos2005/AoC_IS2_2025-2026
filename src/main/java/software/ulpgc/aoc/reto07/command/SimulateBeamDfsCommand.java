package software.ulpgc.aoc.reto07.command;

import software.ulpgc.aoc.reto07.model.*;

import java.util.HashMap;
import java.util.Map;

public class SimulateBeamDfsCommand implements SimalateBeamCommand {
    private final Map<Position, Long> memo = new HashMap<>();
    private final Grid grid;

    public SimulateBeamDfsCommand(Grid grid) {
        this.grid = grid;
    }

    public long simulate() {
        // El rayo empieza por la posición S
        return countTimelines(grid.findStart());
    }

    // Esta función a cambiado de BFS a DFS
    // Además, ahora guarda los recorridos en un hashMap, para no pasar varias veces por el mismo camino
    // de esta manera la complejidad pasa de 2^n a n^2, en caso de ser un input cuadrado
    // En adición, no solo es 2^n de rápido sino que al ser una pirámide el input, es más rápido aún.
    private long countTimelines(Position current) {
        if (!grid.isWithinBounds(current)) return 1;

        if (memo.containsKey(current)) {
            return memo.get(current);
        }

        long totalPaths = 0;
        char cell = grid.getAt(current);

        if (cell == '^') {
            totalPaths = countTimelines(current.left()) + countTimelines(current.right());
        } else if (cell == '.' || cell == 'S'){
            totalPaths = countTimelines(current.down());
        }
        memo.put(current, totalPaths);
        return totalPaths;
    }
}
