package software.ulpgc.aoc.reto11.command;

import software.ulpgc.aoc.reto11.model.ReactorNetwork;

// Comando para Parte 1: Inicio -> Fin
public record DirectPathCalculation(String start, String end) implements PathCommand {
    @Override
    public long execute(ReactorNetwork network) {
        return network.countRoutes(start, end);
    }
}