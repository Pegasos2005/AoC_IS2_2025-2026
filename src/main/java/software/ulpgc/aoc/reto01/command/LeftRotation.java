package software.ulpgc.aoc.reto01.command;

import software.ulpgc.aoc.reto01.model.SafeDial;

public record LeftRotation(int distance) implements RotationCommand {
    @Override
    public int execute(SafeDial dial) {
        return dial.rotateLeftAndCount(distance);
    }
}
