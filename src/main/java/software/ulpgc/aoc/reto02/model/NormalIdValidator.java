package software.ulpgc.aoc.reto02.model;

public class NormalIdValidator implements IdValidator {
    @Override
    public boolean isInvalid(long id) {
        String s = String.valueOf(id);
        int len = s.length();

        // Si id tiene dígitos impares, devuelve false
        if (len % 2 != 0) return false;

        String firstHalf = s.substring(0, len / 2);
        String secondHalf = s.substring(len / 2);
        return firstHalf.equals(secondHalf);
    }
}
