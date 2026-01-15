package software.ulpgc.aoc.reto04;

import software.ulpgc.aoc.reto04.controller.StoreController;
import software.ulpgc.aoc.reto04.io.*;
import software.ulpgc.aoc.reto04.model.RollGrid;
import software.ulpgc.aoc.reto04.view.TotalPrinter;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input04.txt");

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputAdapter(INPUT_PATH);
            RollGrid input = GridParser.parseGrid(reader.readLines());

            // CONTROLLER
            var total = new StoreController().countAccessibleRolls(input);

            // VIEW
            new TotalPrinter().printTotal(total);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
