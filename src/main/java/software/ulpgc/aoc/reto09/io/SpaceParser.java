package software.ulpgc.aoc.reto09.io;

import software.ulpgc.aoc.reto09.model.Point;
import software.ulpgc.aoc.reto09.model.PointSpace;

import java.util.List;
import java.util.stream.Collectors;

public class SpaceParser {
    public static PointSpace buildSpace(List<String> lines) {
        List<Point> points = lines.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    return new Point(
                            Integer.parseInt(parts[0].trim()),
                            Integer.parseInt(parts[1].trim())
                    );
                })
                .collect(Collectors.toList());
        return new PointSpace(points);
    }
}
