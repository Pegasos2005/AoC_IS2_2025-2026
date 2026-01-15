package software.ulpgc.aoc.reto12;

import software.ulpgc.aoc.reto12.controller.FarmController;
import software.ulpgc.aoc.reto12.io.FileInputReader;
import software.ulpgc.aoc.reto12.view.TotalPrinter;

import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input12.txt");

    public static void main(String[] args) {
        try {
            // IO
            var rawData = new FileInputReader(INPUT_PATH).readContent();

            // CONTROLLER
            long result = new FarmController().processSolvableRegions(rawData);

            // VIEW
            new TotalPrinter().print(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}