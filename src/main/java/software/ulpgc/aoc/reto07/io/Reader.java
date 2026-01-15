package software.ulpgc.aoc.reto07.io;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<String> readLines() throws IOException;
}
