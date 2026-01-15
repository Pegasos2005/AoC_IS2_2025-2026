package software.ulpgc.aoc.reto05.controller;

import software.ulpgc.aoc.reto05.command.*;
import software.ulpgc.aoc.reto05.io.FileContent;
import software.ulpgc.aoc.reto05.model.FreshRangesTree;

import java.util.List;

public class InventoryManager {
    private final FreshRangesTree freshRangesTree;

    private InventoryManager(FreshRangesTree ranges) {
        this.freshRangesTree = ranges;
    }

    public static InventoryManager createInventoryManager(FileContent newRanges) {
        FreshRangesTree ranges = new CreateRangesTree().execute(newRanges.ranges());
        return new InventoryManager(ranges);
    }

    public long countFreshIDs(List<Long> numbers) {
        return new CountFreshIds(numbers).execute(freshRangesTree);
    }

    public long countAmountFreshIDs() {
        return new CountAmountFreshIds().execute(freshRangesTree);
    }
}
