package software.ulpgc.aoc.reto05.command;

import software.ulpgc.aoc.reto05.model.FreshRangesTree;

import java.util.Map;

public class CountAmountFreshIds implements CountInTreeCommand {
    public long execute(FreshRangesTree freshRangesTree) {
        long total = 0;
        for (Map.Entry<Long, Long> entry : freshRangesTree.getRangesTree().entrySet()) {
            long start = entry.getKey();
            long end = entry.getValue();
            total += (end - start + 1); // El +1 es xq end tmb cuenta -> rango: (3, 9) -> 9 - 3 + 1 = 7
        }
        return total;
    }
}
