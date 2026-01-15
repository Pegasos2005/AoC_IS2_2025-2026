package software.ulpgc.aoc.reto03.model;

public record BatteryBank(String line) {
    public long getMaxVoltaje(int digits) {
        int length = line.length() - digits + 1;
        int pos = 0;
        int lastPos = 0;
        StringBuilder maxNum = new StringBuilder("");
        for (int i = 0; i < digits; i++) {

            maxNum.append("0");
            while (pos < (length + i) && maxNum.charAt(i) != '9') {
                // Reemplaza el último carac del número x otro, si encuentra uno mayor en la línea
                if (line.charAt(pos) > maxNum.charAt(i)) {
                    maxNum.setCharAt(maxNum.length() - 1, line.charAt(pos));
                    lastPos = pos;
                }
                pos++;

            }
            pos = lastPos + 1;
        }
        return Long.parseLong(maxNum.toString());
    }
}