package software.ulpgc.aoc.reto05.io;

import software.ulpgc.aoc.reto05.model.Range;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class FileParser {
    public static FileContent parserToFC(List<String> lines) throws IOException {
        // Buscamos la línea en blanco que está en medio del archivo
        int divider = IntStream.range(0, lines.size())
                .filter(i -> lines.get(i).isBlank())
                .findFirst()
                .orElse(-1);
        if (divider == -1) {throw new IllegalArgumentException("Formato de archivo inválido: No se encontró la línea de división.");}

        List<Range> ranges = parserToRanges(lines.subList(0, divider));
        List<Long> IDs = parserToIds(lines.subList(divider + 1, lines.size()));

        return new FileContent(ranges, IDs);

    }
    public static List<Long> parserToIds(List<String> lines) throws IOException {
        // Convertimos estas lineas a los IDs
        return lines.stream()
                .filter(line -> !line.isBlank()) // Seguridad extra por si hay líneas vacías al final
                .map(Long::valueOf)          // <--- La magia ocurre aquí
                .toList();
    }

    public static List<Range> parserToRanges(List<String> lines) {
        // Convertimos estas lineas a rangos
        return lines.stream()
                .map(line -> line.split("-"))
                .filter(parts -> parts.length == 2)
                .map(parts -> new Range(
                        Long.parseLong(parts[0].trim()),
                        Long.parseLong(parts[1].trim())
                ))
                .toList();
    }
}
