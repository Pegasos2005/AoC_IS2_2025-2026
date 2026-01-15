package software.ulpgc.aoc.reto11;

import software.ulpgc.aoc.reto11.controller.ReactorController;
import software.ulpgc.aoc.reto11.io.FileInputReader;
import software.ulpgc.aoc.reto11.view.ReactorPrinter;

import java.nio.file.Path;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input11.txt");

    public static void main(String[] args) {
        try {
            // IO
            var data = new FileInputReader(INPUT_PATH).readLines();

            // CONTROLLER (Parte 1: you -> out)
            long result = new ReactorController().calculateWaypointRoute(data, "svr", "out", "dac", "fft");

            // VIEW
            new ReactorPrinter().showResult(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}