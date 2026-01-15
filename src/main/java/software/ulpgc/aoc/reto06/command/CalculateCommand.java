package software.ulpgc.aoc.reto06.command;

import software.ulpgc.aoc.reto06.model.Grid;

import java.util.List;

public class CalculateCommand {
    public long execute(Grid grid) {
        long sum = 0;
        for (int i = 0; i < grid.getWidth(); i++) {
            sum += solveCol(grid.getCol(i), grid.getOperator(i));
        }
        return sum;
    }

    public static long solveCol(List<Integer> col, char oper) {
        long result = 0;
        if (oper == '*') result = MulOperation.operation(col);
        else if (oper == '+') result = SumOperation.operation(col);

        return result;
    }
}
