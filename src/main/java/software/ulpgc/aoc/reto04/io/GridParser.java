package software.ulpgc.aoc.reto04.io;

import software.ulpgc.aoc.reto04.model.RollGrid;

import java.util.List;

public class GridParser {
    public static RollGrid parseGrid(List<String> lines) {
        if (lines.isEmpty()) return null;

        char[][] matrix = lines.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        return new RollGrid(matrix, matrix.length, matrix[0].length);
    }
}
