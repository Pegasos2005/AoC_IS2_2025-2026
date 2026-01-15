package software.ulpgc.aoc.reto10.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileInputAdapter implements Reader {
    private final Path path;

    public FileInputAdapter(Path path) {
        this.path = path;
    }

    @Override
    public List<String> readLines() throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.toList();
        }
    }
}
