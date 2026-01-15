package software.ulpgc.aoc.reto12.command;

import software.ulpgc.aoc.reto12.model.ForestZone;
import software.ulpgc.aoc.reto12.model.TimberShape;
import software.ulpgc.aoc.reto12.model.ZoneSolver;

import java.util.Map;

public class ValidateZoneCommand implements FarmOperation {
    private final ForestZone zone;
    private final Map<Integer, TimberShape> dictionary;
    private final ZoneSolver solver;

    public ValidateZoneCommand(ForestZone zone, Map<Integer, TimberShape> dictionary) {
        this.zone = zone;
        this.dictionary = dictionary;
        this.solver = new ZoneSolver();
    }

    @Override
    public boolean execute() {
        return solver.isSolvable(zone, dictionary);
    }
}