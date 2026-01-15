package software.ulpgc.aoc.reto04.model;

import java.util.stream.IntStream;

public record RollGrid(char[][] grid, int rows, int cols) {

    public boolean isPaperRoll(int r, int c) {
        return r >= 0 && r < rows() && c >= 0 && c < cols() && grid[r][c] == '@';
    }

    public boolean isAccessible(int r, int c) {
        if (grid[r][c] != '@') return false;

        // Contamos rollos de papel adyacentes (9 posiciones)
        long neighbors = IntStream.rangeClosed(-1, 1)
                .boxed()
                .flatMap(dr -> IntStream.rangeClosed(-1, 1)
                        .mapToObj(dc -> new int[]{dr, dc}))
                .filter(offset -> isPaperRoll(r + offset[0], c + offset[1]))
                .count();

        return neighbors < 5; // 1 más contando la del medio
    }

    public boolean deleteAccessibleRoll(int r, int c) {
        if (isAccessible(r, c)) {
            grid[r][c] = '.';
            return true;
        }
        return false;
    }
}