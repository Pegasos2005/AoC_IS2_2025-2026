package software.ulpgc.aoc.reto01;

import software.ulpgc.aoc.reto01.controller.DialController;
import software.ulpgc.aoc.reto01.io.*;

import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input01.txt");

    public static void main(String[] args) {
        try {
            // IO
            Reader reader = new FileInputReader(INPUT_PATH);

            // CONTROLLER
            new DialController().processTimesInZero(reader.readLines());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
