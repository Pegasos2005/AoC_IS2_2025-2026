package software.ulpgc.aoc.reto09.command;

import software.ulpgc.aoc.reto09.model.PointSpace;

public interface AreaCommand {
    long execute(PointSpace space);
}
