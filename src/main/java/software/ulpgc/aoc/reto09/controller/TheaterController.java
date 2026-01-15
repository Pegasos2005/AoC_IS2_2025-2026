package software.ulpgc.aoc.reto09.controller;

import software.ulpgc.aoc.reto09.command.*;
import software.ulpgc.aoc.reto09.model.*;

public class TheaterController {

    public long calculateMaxArea(PointSpace space) {
        return new FindMaxAreaCommand().execute(space);
    }

    public long calculateMaxValidArea(PointSpace space) {
        return new FindMaxValidAreaCommand().execute(space);
    }
}