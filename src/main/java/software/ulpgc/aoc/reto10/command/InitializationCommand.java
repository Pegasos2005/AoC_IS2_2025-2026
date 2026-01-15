package software.ulpgc.aoc.reto10.command;

import software.ulpgc.aoc.reto10.model.MachineLights;

import java.util.List;

public class InitializationCommand implements LightsCommand {
    private final List<MachineLights> machines;

    public InitializationCommand(List<MachineLights> machines) {
        this.machines = machines;
    }

    @Override
    public long execute() {
        return machines.stream()
                .mapToLong(this::findMinPresses)
                .sum();
    }

    private int findMinPresses(MachineLights machine) {
        int n = machine.buttonMasks().size();
        int minPresses = Integer.MAX_VALUE;

        // Probamos todas las combinaciones (2^n)
        for (int i = 0; i < (1 << n); i++) {
            long currentMask = 0;
            int presses = 0;

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    currentMask ^= machine.buttonMasks().get(j); // Operación XOR (toggle)
                    presses++;
                }
            }

            if (currentMask == machine.onPositionMask()) {
                minPresses = Math.min(minPresses, presses);
            }
        }
        return (minPresses == Integer.MAX_VALUE) ? 0 : minPresses;
    }
}
