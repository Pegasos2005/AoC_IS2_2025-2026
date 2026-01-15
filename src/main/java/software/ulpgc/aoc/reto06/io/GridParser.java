package software.ulpgc.aoc.reto06.io;

import software.ulpgc.aoc.reto06.model.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GridParser {

    public static Grid createGrid(List<String> linesFile) {
        if (linesFile.isEmpty()) throw new IllegalArgumentException("El archivo está vacío");

        // Se crea la lista con los operadores ['*', '*', '+', ...]
        List<Character> operators = filterOperations(linesFile.getLast());

        // Se crea la matriz con las columnas de números [[49, 83, 16, 83], [x, x, x, x], [x, x, x, x], [...], ...]
        List<List<Integer>> numbers = filterNumbers(linesFile, operators.size());

        return new Grid(numbers, operators);
    }

    private static List<List<Integer>> filterNumbers(List<String> lines, int size) {
        // Se crea la lista con números vacía [[], [], [], [], ...]
        List<List<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < size; i++) columns.add(new ArrayList<>());

        // Se rellenan en forma de columna [[49, 83, 16, 83], [x, x, x, x], [x, x, x, x], [...], ...]
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] parts = lines.get(i).trim().split("\\s+");
            for (int col = 0; col < parts.length; col++) {
                columns.get(col).add(Integer.valueOf(parts[col]));
            }
        }

        return columns;
    }

    // Elimina los espacios extras en blanco y convierta la última línea en un array de Characs
    private static List<Character> filterOperations(String lastLine) {
        return Arrays.stream(lastLine.trim().split("\\s+"))
                .map(s -> s.charAt(0))     // Tomamos el primer carácter del String "L"
                .toList();
    }
}