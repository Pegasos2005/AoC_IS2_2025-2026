package software.ulpgc.aoc.reto05.io;

import software.ulpgc.aoc.reto05.model.Range;

import java.util.List;

public record FileContent(List<Range> ranges, List<Long> numbers) {}
