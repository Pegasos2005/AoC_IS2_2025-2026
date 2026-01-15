package software.ulpgc.aoc.reto03.controller;

import software.ulpgc.aoc.reto03.view.TotalPrinter;
import software.ulpgc.aoc.reto03.command.CalculateMaxVolt;
import software.ulpgc.aoc.reto03.model.BatteryBank;

import java.util.List;

public class VoltajeController {
    private final int digits;

    private VoltajeController(int digits) {
        this.digits = digits;
    }

    public static VoltajeController createrVoltajeController(int digits) {
        return new VoltajeController(digits);
    }

    public void solve(List<BatteryBank> bateries) {
        printTotal(new CalculateMaxVolt(bateries, digits).execute());
    }

    private void printTotal(long total) {
        // VIEW
        new TotalPrinter().printTotal(total);
    }
}