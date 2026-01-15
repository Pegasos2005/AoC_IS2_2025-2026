package software.ulpgc.aoc.reto07.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class GridWriter {
    public static void write(Path path, String content) throws IOException {
        // Usamos la API moderna de Java NIO
        Files.writeString(path, content, StandardCharsets.UTF_8);
    }
}
