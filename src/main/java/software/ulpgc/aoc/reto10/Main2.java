package software.ulpgc.aoc.reto10;

import software.ulpgc.aoc.reto10.controller.MachineController;
import software.ulpgc.aoc.reto10.io.FileInputAdapter;
import software.ulpgc.aoc.reto10.io.MachineVoltParser;
import software.ulpgc.aoc.reto10.view.PressPrinter;

import java.nio.file.Path;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input10.txt");

    public static void main(String[] args) {
        try {
            // IO
            var lines = new FileInputAdapter(INPUT_PATH).readLines();
            var machinesVolts = MachineVoltParser.parse(lines);

            // CONTROLLER
            long total =  new MachineController().regulerVoltMachines(machinesVolts);

            // VIEW
            new PressPrinter().showResult(total);

        } catch (Exception e) {
            System.err.println("Error en la ejecución: " + e.getMessage());
        }
    }
}