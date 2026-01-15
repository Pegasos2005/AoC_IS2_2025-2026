package software.ulpgc.aoc.reto02.command;

import software.ulpgc.aoc.reto02.model.IdRange;
import software.ulpgc.aoc.reto02.model.IdValidator;

import java.util.List;

public class CalculateSumCommand {
    private final List<IdRange> ranges;
    private final IdValidator validator;

    public CalculateSumCommand(List<IdRange> ranges, IdValidator validator) {
        this.ranges = ranges;
        this.validator = validator;
    }

    public long execute() {
        return ranges.stream()
                .flatMapToLong(IdRange::stream)
                .filter(validator::isInvalid)
                .sum();
    }
}