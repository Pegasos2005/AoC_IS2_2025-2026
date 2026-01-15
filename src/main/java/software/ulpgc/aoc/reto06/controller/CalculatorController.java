package software.ulpgc.aoc.reto06.controller;

import software.ulpgc.aoc.reto06.command.CalculateCommand;
import software.ulpgc.aoc.reto06.model.Grid;

public class CalculatorController {
    public static long solve(Grid grid) {
        return new CalculateCommand().execute(grid);
    }
}