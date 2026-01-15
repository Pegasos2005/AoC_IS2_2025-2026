package software.ulpgc.aoc.reto09.command;

import software.ulpgc.aoc.reto09.model.*;

import java.util.stream.IntStream;

public class FindMaxValidAreaCommand implements AreaCommand {
    private record Candidate(int minX, int maxX, int minY, int maxY, long area) {}

    @Override
    public long execute(PointSpace space) {
        int n = space.size();

        return IntStream.range(0, n).parallel()
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, n)
                        .mapToObj(j -> createCandidate(space.get(i), space.get(j))))
                .filter(c -> isValid(c, space))
                .mapToLong(Candidate::area)
                .max()
                .orElse(0L);
    }

    private Candidate createCandidate(Point p1, Point p2) {
        int minX = Math.min(p1.x(), p2.x());
        int maxX = Math.max(p1.x(), p2.x());
        int minY = Math.min(p1.y(), p2.y());
        int maxY = Math.max(p1.y(), p2.y());

        // Área inclusiva (+1)
        long area = (long) (maxX - minX + 1) * (maxY - minY + 1);

        return new Candidate(minX, maxX, minY, maxY, area);
    }

    private boolean isValid(Candidate rect, PointSpace space) {
        // 2. Verificar paredes (Delegamos la complejidad al modelo)
        return !space.intersectsWalls(rect.minX, rect.maxX, rect.minY, rect.maxY);
    }
}
