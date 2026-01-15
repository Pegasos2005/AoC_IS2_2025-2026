package software.ulpgc.aoc.reto05;

import software.ulpgc.aoc.reto05.controller.InventoryManager;
import software.ulpgc.aoc.reto05.io.FileInputReader;
import software.ulpgc.aoc.reto05.io.FileParser;
import software.ulpgc.aoc.reto05.io.Reader;
import software.ulpgc.aoc.reto05.view.TotalPrinter;

import java.io.IOException;
import java.nio.file.Path;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input05.txt");

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputReader(INPUT_PATH);
            var inputParsed = FileParser.parserToFC(reader.readLines());

            // CONTROLLER
            InventoryManager manager = InventoryManager.createInventoryManager(inputParsed);
            long total = manager.countAmountFreshIDs();

            // VIEW
            new TotalPrinter().printTotal(total);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
