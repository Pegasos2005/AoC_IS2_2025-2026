package software.ulpgc.aoc.reto10.command;

import software.ulpgc.aoc.reto10.model.MachineVolts;

import java.util.List;

public class VoltRegulerCommand {
    private final List<MachineVolts> machines;
    private long bestPresses;
    private boolean[][] canAffect; // Matriz para saber si un botón futuro afecta a un contador

    public VoltRegulerCommand(List<MachineVolts> machines) {
        this.machines = machines;
    }

    public long execute() {
        return machines.stream()
                .mapToLong(this::findMinimalPresses)
                .sum();
    }

    private long findMinimalPresses(MachineVolts m) {
        this.bestPresses = Long.MAX_VALUE;
        int numButtons = m.buttons().size();
        int numCounters = m.targets().length;

        // Pre-calculamos la alcanzabilidad
        // canAffect[i][j] es true si el botón 'i' o cualquier botón posterior afecta al contador 'j'
        canAffect = new boolean[numButtons + 1][numCounters];
        for (int i = numButtons - 1; i >= 0; i--) {
            System.arraycopy(canAffect[i + 1], 0, canAffect[i], 0, numCounters);
            for (int counterIdx : m.buttons().get(i)) {
                if (counterIdx < numCounters) canAffect[i][counterIdx] = true;
            }
        }
        System.out.println(m);

        solve(m, 0, new int[numCounters], 0);
        return bestPresses == Long.MAX_VALUE ? 0 : bestPresses;
    }

    private void solve(MachineVolts m, int buttonIdx, int[] current, long totalSoFar) {
        if (totalSoFar >= bestPresses) return;

        int numCounters = m.targets().length;

        for (int i = 0; i < numCounters; i++) {
            if (current[i] < m.targets()[i] && !canAffect[buttonIdx][i]) return;
            if (current[i] > m.targets()[i]) return; // Ya nos pasamos
        }

        if (buttonIdx == m.buttons().size()) {
            if (isMatch(current, m.targets())) bestPresses = totalSoFar;
            return;
        }

        int requiredT = -1;
        for (int i = 0; i < numCounters; i++) {
            if (current[i] < m.targets()[i] && !canAffect[buttonIdx + 1][i]) {
                // El botón actual DEBE cubrir lo que falta para el contador 'i'
                int needed = m.targets()[i] - current[i];
                // ¿Afecta este botón al contador i?
                boolean affectsI = false;
                for (int c : m.buttons().get(buttonIdx)) if (c == i) affectsI = true;

                if (!affectsI) return; // Imposible cumplir el target

                if (requiredT != -1 && requiredT != needed) return; // Conflictos
                requiredT = needed;
            }
        }

        int[] buttonEffects = m.buttons().get(buttonIdx);

        if (requiredT != -1) {
            // Caso determinista: Solo probamos una opción
            apply(current, buttonEffects, requiredT);
            solve(m, buttonIdx + 1, current, totalSoFar + requiredT);
            apply(current, buttonEffects, -requiredT); // Backtrack
        } else {
            // Caso general: Calcular maxTimes y probar
            int maxTimes = calculateMaxTimes(m, buttonIdx, current);
            for (int t = maxTimes; t >= 0; t--) {
                apply(current, buttonEffects, t);
                solve(m, buttonIdx + 1, current, totalSoFar + t);
                apply(current, buttonEffects, -t);
            }
        }
    }

    private int calculateMaxTimes(MachineVolts m, int buttonIdx, int[] current) {
        int max = Integer.MAX_VALUE;
        int[] targets = m.targets();
        for (int counterIdx : m.buttons().get(buttonIdx)) {
            if (counterIdx < targets.length) {
                int diff = targets[counterIdx] - current[counterIdx];
                max = Math.min(max, diff);
            }
        }
        return max == Integer.MAX_VALUE ? 0 : max;
    }

    private void apply(int[] current, int[] effects, int times) {
        for (int idx : effects) {
            if (idx < current.length) current[idx] += times;
        }
    }

    private boolean isMatch(int[] cur, int[] tar) {
        for (int i = 0; i < tar.length; i++) if (cur[i] != tar[i]) return false;
        return true;
    }
}