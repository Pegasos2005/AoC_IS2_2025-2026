package software.ulpgc.aoc.reto02.model;

import java.util.stream.LongStream;

public record IdRange(long start, long end) {
    // Genera un stream de todos los números dentro del rango
    public LongStream stream() {
        return LongStream.rangeClosed(start, end);
    }
}
