package software.ulpgc.aoc.reto03;

import software.ulpgc.aoc.reto03.controller.VoltajeController;
import software.ulpgc.aoc.reto03.io.*;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input03.txt");
    private static final int digits = 12;

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputReader(INPUT_PATH);
            var input = BatteryParser.parseBatteries(reader.readLines());

            // CONTROLLER
            var controller = VoltajeController.createrVoltajeController(digits); // Introduce la cantidad de dígitos deseada
            controller.solve(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
