package software.ulpgc.aoc.reto12.io;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<String> readContent() throws IOException;
}