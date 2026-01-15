package software.ulpgc.aoc.reto01.controller;

import software.ulpgc.aoc.reto01.command.*;
import software.ulpgc.aoc.reto01.model.SafeDial;
import software.ulpgc.aoc.reto01.view.TotalPrinter;

import java.util.List;

public class DialController {

    // Uso de Factory Method para crear comandos de forma limpia[cite: 220].
    private RotationCommand moveDial(String line) {
        char direction = line.charAt(0);
        int distance = Integer.parseInt(line.substring(1));
        return (direction == 'R') ? new RightRotation(distance) : new LeftRotation(distance);
    }

    public long processTimesInZero(List<String> data, int dialPosition) {
        SafeDial dial = new SafeDial(dialPosition);
        long total = data.stream()
                .map(this::moveDial)
                .filter(cmd -> {
                    cmd.execute(dial);
                    return dial.isAtZero();
                })
                .count();

        // VIEW
        printTotal(total);
        return total;
    }

    public long processTimesByZero(List<String> data, int dialPosition) {
        SafeDial dial = new SafeDial(dialPosition);

        // Pipeline funcional: transformamos líneas en comandos y sumamos sus resultados[cite: 513].
        long total = data.stream()
                .map(this::moveDial)
                .mapToInt(cmd -> cmd.execute(dial)) // Obtenemos el conteo de cada rotación
                .sum(); // Suma total de todos los pasos por cero

        // VIEW
        printTotal(total);
        return total;
    }

    private void printTotal(long total) {
        // VIEW
        new TotalPrinter().printTotal(total);
    }
}