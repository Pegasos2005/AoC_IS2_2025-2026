package software.ulpgc.aoc.reto06.command;

import java.util.List;

public class MulOperation implements Operation {
    static long operation(List<Integer> col){
        return col.stream()
                .mapToLong(Integer::longValue)
                .reduce(1, (a, b) -> a * b);
    }
}
