package software.ulpgc.aoc.reto07.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Grid {
    private final char[][] matrix;
    private final int rows;
    private final int cols;

    public Grid(char[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    // Posición válida?
    public boolean isWithinBounds(Position p) {
        return p.row() >= 0 && p.row() < rows && p.col() >= 0 && p.col() < cols;
    }

    // Obtener char
    public char getAt(Position p) {
        return matrix[p.row()][p.col()];
    }

    public void setAt(Position p, char value) {
        if (isWithinBounds(p)) {
            matrix[p.row()][p.col()] = value;
        }
    }

    // Obtener S (la posición inicial)
    public Position findStart() {
        int col = new String(matrix[0]).indexOf('S');
        if (col == -1) throw new IllegalStateException("No se encontró 'S'");
        return new Position(0, col);
    }

    public String render() {
        return Arrays.stream(matrix)
                .map(String::new)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
