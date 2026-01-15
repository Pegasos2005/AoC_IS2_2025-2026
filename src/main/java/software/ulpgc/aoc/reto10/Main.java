package software.ulpgc.aoc.reto10;

import software.ulpgc.aoc.reto10.controller.MachineController;
import software.ulpgc.aoc.reto10.io.FileInputAdapter;
import software.ulpgc.aoc.reto10.io.MachineLigthsParser;
import software.ulpgc.aoc.reto10.view.PressPrinter;

import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input10.txt");

    public static void main(String[] args) {
        try {
            // IO
            var lines = new FileInputAdapter(INPUT_PATH).readLines();
            var machinesLights = MachineLigthsParser.parse(lines);

            // CONTROLLER
            long total =  new MachineController().turnOnMachines(machinesLights);

            // VIEW
            new PressPrinter().showResult(total);

        } catch (Exception e) {
            System.err.println("Error en la ejecución: " + e.getMessage());
        }
    }
}