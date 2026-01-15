package software.ulpgc.aoc.reto01.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileInputReader implements Reader {
    private final Path path;

    public FileInputReader(Path path) {
        this.path = path;
    }

    @Override
    public List<String> readLines() throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.toList();
        }
    }
}
