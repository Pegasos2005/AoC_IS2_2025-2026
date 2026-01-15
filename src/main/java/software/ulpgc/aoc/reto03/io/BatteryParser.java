package software.ulpgc.aoc.reto03.io;

import software.ulpgc.aoc.reto03.model.BatteryBank;

import java.util.List;

public class BatteryParser {
    public static List<BatteryBank> parseBatteries(List<String> lines) {
        return lines.stream()
                .map(BatteryBank::new)
                .toList();
    }
}
