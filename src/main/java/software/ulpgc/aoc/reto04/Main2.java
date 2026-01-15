package software.ulpgc.aoc.reto04;

import software.ulpgc.aoc.reto01.view.TotalPrinter;
import software.ulpgc.aoc.reto04.controller.StoreController;
import software.ulpgc.aoc.reto04.io.FileInputAdapter;
import software.ulpgc.aoc.reto04.io.GridParser;
import software.ulpgc.aoc.reto04.io.Reader;

import java.io.IOException;
import java.nio.file.Path;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input04.txt");

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputAdapter(INPUT_PATH);
            var input = GridParser.parseGrid(reader.readLines());

            // CONTROLLER
            var total = new StoreController().removeAllAccessRolls(input);

            // VIEW
            new TotalPrinter().printTotal(total);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
