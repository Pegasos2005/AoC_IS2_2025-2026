package software.ulpgc.aoc.reto09;

import software.ulpgc.aoc.reto09.controller.TheaterController;
import software.ulpgc.aoc.reto09.io.*;
import software.ulpgc.aoc.reto09.view.TotalPrinter;

import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input09.txt");

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputAdapter(INPUT_PATH);
            var input = SpaceParser.buildSpace(reader.readLines());

            // CONTROLLER
            long maxArea = new TheaterController().calculateMaxArea(input);

            // VIEW
            new TotalPrinter().printTotal(maxArea);

        } catch (Exception e) {
            System.err.println("Error en la ejecución: " + e.getMessage());
        }
    }
}