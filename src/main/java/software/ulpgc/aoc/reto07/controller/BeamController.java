package software.ulpgc.aoc.reto07.controller;

import software.ulpgc.aoc.reto07.command.*;
import software.ulpgc.aoc.reto07.model.Grid;

public class BeamController {
    private final Grid grid;

    private BeamController(Grid grid) {
        this.grid = grid;
    }

    public static BeamController createBeamController(Grid grid) {
        return new BeamController(grid);
    }

    public long simulateBfs() {
        return new SimulateBeamBfsCommand(grid).simulate();
    }

    public long simulateDfs() {
        return new SimulateBeamDfsCommand(grid).simulate();
    }
}
