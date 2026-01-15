package software.ulpgc.aoc.reto05.command;

import software.ulpgc.aoc.reto05.model.FreshRangesTree;
import software.ulpgc.aoc.reto05.model.Range;

import java.util.List;
import java.util.TreeMap;

public class CreateRangesTree {
    public FreshRangesTree execute(List<Range> ranges) {
        FreshRangesTree tree = new FreshRangesTree(new TreeMap<>());
        ranges.forEach(r -> tree.add(r.start(), r.end()));
        return tree;
    }
}
