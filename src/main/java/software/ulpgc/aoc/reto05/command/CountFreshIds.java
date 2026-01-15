package software.ulpgc.aoc.reto05.command;

import software.ulpgc.aoc.reto05.model.FreshRangesTree;

import java.util.List;

public class CountFreshIds implements CountInTreeCommand {
    private List<Long> numbers;
    public CountFreshIds(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    public long execute(FreshRangesTree freshRangesTree) {
        return numbers.stream()
                .filter(freshRangesTree::contains)
                .count();
    }
}
