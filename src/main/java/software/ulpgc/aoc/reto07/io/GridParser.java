package software.ulpgc.aoc.reto07.io;

import software.ulpgc.aoc.reto07.model.Grid;

import java.io.IOException;
import java.util.List;

public class GridParser {
    public static Grid readFromFile(List<String> lines) throws IOException {
        if (lines.isEmpty()) throw new IllegalArgumentException("El archivo está vacío");

        char[][] matrix = lines.stream()
                .filter(line -> !line.isBlank())
                .map(String::toCharArray)
                .toArray(char[][]::new);

        return new Grid(matrix);
    }
}
