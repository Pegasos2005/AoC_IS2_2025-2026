package software.ulpgc.aoc.reto07.command;

import software.ulpgc.aoc.reto07.model.*;

import java.util.ArrayDeque;
import java.util.Queue;

public class SimulateBeamBfsCommand implements SimalateBeamCommand {
    private final Grid grid;
    private final Queue<Position> beamQueue = new ArrayDeque<>();
    private long activatedSliptters = 0;

    public SimulateBeamBfsCommand(Grid grid) {
        this.grid = grid;
    }

    public long simulate() {
        // Guarda la posición de S en memoria
        beamQueue.add(grid.findStart());

        while (!beamQueue.isEmpty()) {
            traceDownward(beamQueue.poll());
        }

        return activatedSliptters;

    }

    private void traceDownward(Position current) {
        if (!grid.isWithinBounds(current)) return;

        char cell = grid.getAt(current);

        if (cell == '^') {
            activatedSliptters++;
            grid.isWithinBounds(current);

            beamQueue.add(current.left());
            beamQueue.add(current.right());
        } else if (cell == '.' || cell == 'S'){
            grid.setAt(current, '|');
            beamQueue.add(current.down());
        }
    }
}
