package software.ulpgc.aoc.reto05.model;

public record Range(long start, long end) {
    public String toString() {
        return start + " : " + end;
    }
}
