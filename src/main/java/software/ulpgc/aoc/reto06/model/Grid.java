package software.ulpgc.aoc.reto06.model;

import java.util.List;

public record Grid(List<List<Integer>> numbers, List<Character> operators) {
    public int getWidth() {
        return numbers.size();
    }

    public char getOperator(int col) {
        return operators.get(col);
    }

    public List<Integer> getCol(int col) {
        return numbers.get(col);
    }
}