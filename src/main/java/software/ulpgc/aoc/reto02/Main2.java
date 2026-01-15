package software.ulpgc.aoc.reto02;

import software.ulpgc.aoc.reto02.controller.RangesController;
import software.ulpgc.aoc.reto02.io.*;
import software.ulpgc.aoc.reto02.model.AdvancedIdValidator;

import java.io.IOException;
import java.nio.file.Path;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input02.txt");

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputReader(INPUT_PATH);
            var ranges = new RangesParser().idParser(reader.readLine());

            // CONTROLLER
            var validator = new AdvancedIdValidator();
            var controller = RangesController.creatorRangesController(validator);
            controller.processRanges(ranges);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
