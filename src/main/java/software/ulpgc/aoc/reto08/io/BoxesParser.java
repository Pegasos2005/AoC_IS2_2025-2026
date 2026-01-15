package software.ulpgc.aoc.reto08.io;

import software.ulpgc.aoc.reto08.model.Box;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BoxesParser {
    public static List<Box> readBoxes(List<String> lines) {
        // AtomicInteger es como usar i=0; i++ dentro de la Stream, pero usar esta clase
        // evita problemas de concurrencia dentro de Stream.parallelStream() y es x esta función que dentro
        // de Stream no se pueden modificar variables que se estén usando.
        AtomicInteger idGenerator = new AtomicInteger(0);

        return lines.stream()
                .filter(line -> !line.isBlank())
                .map(line -> {
                    String[] parts = line.split(",");
                    return new Box(
                            Integer.parseInt(parts[0].trim()),
                            Integer.parseInt(parts[1].trim()),
                            Integer.parseInt(parts[2].trim()),
                            idGenerator.getAndIncrement()
                    );
                })
                .toList();
    }
}