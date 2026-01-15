package software.ulpgc.aoc.reto10.io;

import software.ulpgc.aoc.reto10.model.MachineVolts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MachineVoltParser {
    public static List<MachineVolts> parse(List<String> lines) {
        List<MachineVolts> machines = new ArrayList<>();
        Pattern buttonPattern = Pattern.compile("\\((.*?)\\)");
        Pattern digitPattern = Pattern.compile("\\d+");

        for (String line : lines) {
            if (line.isBlank()) continue;

            // 1. Extraer targets {46,36,...}
            String targetPart = line.substring(line.indexOf("{") + 1, line.indexOf("}"));
            String[] targetStrs = targetPart.split(",");
            int[] targets = new int[targetStrs.length];
            for (int i = 0; i < targetStrs.length; i++) {
                targets[i] = Integer.parseInt(targetStrs[i].trim());
            }

            // 2. Extraer botones (0,3,4)
            List<int[]> buttons = new ArrayList<>();
            Matcher btnMatcher = buttonPattern.matcher(line);

            while (btnMatcher.find()) {
                String content = btnMatcher.group(1);
                Matcher digitMatcher = digitPattern.matcher(content);
                List<Integer> indices = new ArrayList<>();
                while (digitMatcher.find()) {
                    indices.add(Integer.parseInt(digitMatcher.group()));
                }
                buttons.add(indices.stream().mapToInt(i -> i).toArray());
            }

            machines.add(new MachineVolts(targets, buttons));
        }
        return machines;
    }
}
