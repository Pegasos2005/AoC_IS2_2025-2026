package software.ulpgc.aoc.reto09.command;

import software.ulpgc.aoc.reto09.model.Point;
import software.ulpgc.aoc.reto09.model.PointSpace;

import java.util.stream.IntStream;

public class FindMaxAreaCommand implements AreaCommand {
    @Override
    public long execute(PointSpace space) {
        int n = space.size();

        return IntStream.range(0, n).parallel()
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, n)
                        .mapToObj(j -> calculateMetric(space.get(i), space.get(j))))
                .mapToLong(Long::longValue)
                .max()
                .orElse(0L);
    }

    private long calculateMetric(Point p1, Point p2) {
        // (Diferencia + 1) * (Diferencia + 1)
        long w = Math.abs(p1.x() - p2.x()) + 1;
        long h = Math.abs(p1.y() - p2.y()) + 1;
        return w * h;
    }
}