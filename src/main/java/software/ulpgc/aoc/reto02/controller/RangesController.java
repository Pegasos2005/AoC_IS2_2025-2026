package software.ulpgc.aoc.reto02.controller;

import software.ulpgc.aoc.reto01.view.TotalPrinter;
import software.ulpgc.aoc.reto02.command.CalculateSumCommand;
import software.ulpgc.aoc.reto02.model.IdRange;
import software.ulpgc.aoc.reto02.model.IdValidator;

import java.util.List;

public class RangesController {
    private final IdValidator validator;

    private RangesController(IdValidator validator) {
        this.validator = validator;
    }

    // Factory Method
    public static RangesController creatorRangesController(IdValidator validator) {
        return new RangesController(validator);
    }

    public void processRanges(List<IdRange> ranges) {
        printTotal(new CalculateSumCommand(ranges, validator).execute());
    }

    private void printTotal(long total) {
        // VIEW
        new TotalPrinter().printTotal(total);
    }
}
