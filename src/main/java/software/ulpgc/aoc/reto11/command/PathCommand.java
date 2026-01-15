package software.ulpgc.aoc.reto11.command;

import software.ulpgc.aoc.reto11.model.ReactorNetwork;

public interface PathCommand {
    long execute(ReactorNetwork network);
}