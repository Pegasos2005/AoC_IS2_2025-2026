package software.ulpgc.aoc.reto06;

import software.ulpgc.aoc.reto06.controller.CalculatorController;
import software.ulpgc.aoc.reto06.io.*;
import software.ulpgc.aoc.reto06.view.*;

import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input06.txt");

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputReader(INPUT_PATH);
            var grid = GridParser.createGrid(reader.readLines());

            // CONTROLLER
            long total = CalculatorController.solve(grid);

            // VIEW
            new TotalPrinter().printTotal(total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}