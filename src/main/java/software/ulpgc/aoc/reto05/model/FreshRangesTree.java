package software.ulpgc.aoc.reto05.model;

import java.util.Map;
import java.util.TreeMap;

public record FreshRangesTree(TreeMap<Long, Long> freshRanges) {

    public void add(long start, long end) {
        Map.Entry<Long, Long> previous = freshRanges.floorEntry(start);

        // Caso 1: El nuevo rango ya está totalmente contenido en uno existente
        if (previous != null && previous.getValue() >= end) {
            return;
        }

        // Caso 2: El nuevo rango solapa con el final del anterior, extendemos el inicio
        if (previous != null && previous.getValue() >= start) {
            start = previous.getKey();
        }

        // Caso 3: Eliminar y fusionar todos los rangos posteriores que solapen
        Map.Entry<Long, Long> next = freshRanges.ceilingEntry(start);
        while (next != null && next.getKey() <= end) {
            end = Math.max(end, next.getValue());
            freshRanges.remove(next.getKey());
            next = freshRanges.ceilingEntry(start);
        }

        freshRanges.put(start, end);
    }

    public boolean contains(long id) {
        Map.Entry<Long, Long> entry = freshRanges.floorEntry(id);
        // Verificamos si existe un rango anterior y si el ID cae dentro de él
        return entry != null && id <= entry.getValue();
    }

    public TreeMap<Long, Long> getRangesTree() {
        return new TreeMap<>(freshRanges);
    }
}
