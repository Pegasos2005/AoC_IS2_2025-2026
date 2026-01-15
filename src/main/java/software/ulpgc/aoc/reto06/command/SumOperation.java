package software.ulpgc.aoc.reto06.command;

import java.util.List;

public class SumOperation implements Operation {
    static long operation(List<Integer> col){
        return col.stream()
                .mapToLong(Integer::longValue)
                .reduce(1, Long::sum);
    }
}
