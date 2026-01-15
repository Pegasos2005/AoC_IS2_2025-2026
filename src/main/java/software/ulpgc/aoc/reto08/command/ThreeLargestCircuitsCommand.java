package software.ulpgc.aoc.reto08.command;

import software.ulpgc.aoc.reto08.model.Conections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ThreeLargestCircuitsCommand {
    private final Conections conections;
    public ThreeLargestCircuitsCommand(Conections conections) {
        this.conections = conections;
    }

    public long execute() {
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < conections.parent().length; i++) {
            // Solo si el nodo es el "jefe" de su grupo, su tamaño es real
            if (conections.parent()[i] == i) {
                sizes.add(conections.size()[i]);
            }
        }

        return sizes.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(1, (a, b) -> a * b)
                .longValue();
    }
}
