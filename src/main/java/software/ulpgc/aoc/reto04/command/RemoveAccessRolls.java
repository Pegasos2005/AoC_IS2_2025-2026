package software.ulpgc.aoc.reto04.command;

import software.ulpgc.aoc.reto04.model.RollGrid;

import java.util.stream.IntStream;

public class RemoveAccessRolls implements RollsCommand {
    private final RollGrid grid;

    public RemoveAccessRolls(RollGrid grid) {
        this.grid = grid;
    }

    @Override
    public long execute() {
        return IntStream.range(0, grid.rows())
                .boxed()
                .flatMapToLong(r -> IntStream.range(0, grid.cols())
                        .filter(c -> grid.deleteAccessibleRoll(r, c))
                        .mapToLong(c -> 1))
                .sum();
    }
}
