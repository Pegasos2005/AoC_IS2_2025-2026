package software.ulpgc.aoc.reto11.controller;

import software.ulpgc.aoc.reto11.command.DirectPathCalculation;
import software.ulpgc.aoc.reto11.command.WaypointPathCalculation;
import software.ulpgc.aoc.reto11.model.ReactorNetwork;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReactorController {

    // Helper: Parsea el texto "nodo: vecino1 vecino2" al Modelo
    private ReactorNetwork buildNetwork(List<String> lines) {
        Map<String, List<String>> map = lines.stream()
                .filter(line -> !line.trim().isEmpty())
                .map(line -> line.split(":"))
                .collect(Collectors.toMap(
                        parts -> parts[0].trim(),
                        parts -> Arrays.stream(parts[1].trim().split("\\s+"))
                                .collect(Collectors.toList())
                ));
        return new ReactorNetwork(map);
    }

    public long calculateSimpleRoute(List<String> data, String start, String end) {
        ReactorNetwork network = buildNetwork(data);
        return new DirectPathCalculation(start, end).execute(network);
    }

    public long calculateWaypointRoute(List<String> data, String start, String end, String w1, String w2) {
        ReactorNetwork network = buildNetwork(data);
        return new WaypointPathCalculation(start, end, w1, w2).execute(network);
    }
}