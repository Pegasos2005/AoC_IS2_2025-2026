package software.ulpgc.aoc.reto08;

import software.ulpgc.aoc.reto08.io.*;
import software.ulpgc.aoc.reto08.controller.CircuitController;
import software.ulpgc.aoc.reto08.model.Box;
import software.ulpgc.aoc.reto08.view.*;

import java.nio.file.Path;
import java.util.List;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input08.txt");

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputReader(INPUT_PATH);
            List<Box> boxes = BoxesParser.readBoxes(reader.readLines());

            // CONTROLLER
            CircuitController controller = CircuitController.createCircuitManager(boxes);
            controller.calculateContections();
            long total = controller.calculateLargeConection();

            // VIEW
            Printer printer = new TotalPrinter();
            printer.printTotal(total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}