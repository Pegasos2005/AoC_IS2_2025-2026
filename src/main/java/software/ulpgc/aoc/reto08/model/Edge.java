package software.ulpgc.aoc.reto08.model;

public record Edge(int id1, int id2, long distanceSq) implements Comparable<Edge> {
    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.distanceSq, o.distanceSq);
    }
}