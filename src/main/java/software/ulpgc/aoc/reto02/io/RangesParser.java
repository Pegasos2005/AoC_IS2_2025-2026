package software.ulpgc.aoc.reto02.io;

import software.ulpgc.aoc.reto02.model.IdRange;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RangesParser {
    public List<IdRange> idParser(String lines) {
        return Arrays.stream(lines.split(","))
                .map(s -> s.trim().split("-"))
                .map(parts -> new IdRange(Long.parseLong(parts[0]), Long.parseLong(parts[1])))
                .collect(Collectors.toList());

    }
}
