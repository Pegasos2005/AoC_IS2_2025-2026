package software.ulpgc.aoc.reto03.command;

import software.ulpgc.aoc.reto03.model.BatteryBank;

import java.util.List;

public class CalculateMaxVolt {
    private final List<BatteryBank> banks;
    private final int digits;

    public CalculateMaxVolt(List<BatteryBank> banks, int digits) {
        this.banks = banks;
        this.digits = digits;
    }

    public long execute() {
        return banks.stream()
                .mapToLong(bank -> bank.getMaxVoltaje(digits))
                .sum();
    }
}
