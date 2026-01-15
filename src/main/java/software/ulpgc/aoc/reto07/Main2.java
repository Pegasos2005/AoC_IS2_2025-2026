package software.ulpgc.aoc.reto07;

import software.ulpgc.aoc.reto07.controller.BeamController;
import software.ulpgc.aoc.reto07.io.*;
import software.ulpgc.aoc.reto07.view.*;

import java.io.IOException;
import java.nio.file.Path;


public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input07.txt");

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputReader(INPUT_PATH);
            var grid = GridParser.readFromFile(reader.readLines());

            // 2. Ejecutamos la simulación
            var controller = BeamController.createBeamController(grid);
            long total = controller.simulateDfs();

            // VIEW
            Printer printer = new TotalPrinter();
            printer.printTotal(total);

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado en la simulación: " + e.getMessage());
            e.printStackTrace();
        }

    }
}