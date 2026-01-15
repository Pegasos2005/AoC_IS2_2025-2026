package software.ulpgc.aoc.reto09.io;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<String> readLines() throws IOException;
}
