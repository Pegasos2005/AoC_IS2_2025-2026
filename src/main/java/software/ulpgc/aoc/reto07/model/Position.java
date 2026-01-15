package software.ulpgc.aoc.reto07.model;

public record Position(int row, int col) {
    public Position down() { return new Position(row + 1, col); }
    public Position left() { return new Position(row, col - 1); }
    public Position right() { return new Position(row, col + 1); }
}
