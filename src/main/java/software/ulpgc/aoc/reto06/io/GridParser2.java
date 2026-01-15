package software.ulpgc.aoc.reto06.io;

import software.ulpgc.aoc.reto06.model.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GridParser2 {
    public static Grid createGrid(List<String> linesFile) {
        if (linesFile.isEmpty()) throw new IllegalArgumentException("El archivo está vacío");

        // Se crea la lista con los operadores ['*', '*', '+', ...]
        List<Character> operators = parseOperators(linesFile.getLast());

        // Se crea la matriz con las columnas de números [[49, 83, 16, 83], [x, x, x, x], [x, x, x, x], [...], ...]
        List<List<Integer>> numbers = filterNumbers(linesFile, operators.size());

        return new Grid(numbers, operators);
    }

    private static List<List<Integer>> filterNumbers(List<String> lines, int size) {
        List<String> numberLines = lines.subList(0, lines.size()-1); // Matriz a leer

        List<List<Integer>> numbers = Stream.generate(ArrayList<Integer>::new) // Matriz a escribir
                .limit(size)
                .collect(Collectors.toList());

        int iArray = 0;
        for (int col = 0; col < numberLines.getFirst().length(); col++) {
            int numColumn = readCol(numberLines, col);

            if (numColumn != 0) numbers.get(iArray).add(numColumn);
            else iArray++;
        }

        return numbers;
    }

    private static int readCol(List<String> numberLines, int i) {
        int numColumn = 0;
        for (int j = 0; j < numberLines.size(); j++) {
            int c = 0;
            if (numberLines.get(j).charAt(i) != ' ') {
                numColumn *= 10;
                c = Character.getNumericValue(numberLines.get(j).charAt(i));
                if (c < 0 || 9 < c) throw new IllegalArgumentException("Un caracter de la columna no era un número. Encontrado: '" + c + "'");
            }
            numColumn += c;
        }
        return numColumn;

    }

    // Elimina los espacios extras en blanco y convierta la última línea en un array de Characs
    private static List<Character> parseOperators(String line) {
        return Arrays.stream(line.trim().split("\\s+"))
                .map(s -> s.charAt(0))     // Tomamos el primer carácter del String "L"
                .toList();
    }

}
