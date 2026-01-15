package software.ulpgc.aoc.reto02.model;

public class AdvancedIdValidator implements IdValidator {
    @Override
    public boolean isInvalid(long id) {
        String s = String.valueOf(id);
        int n = s.length();

        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                String pattern = s.substring(0, len);
                if (isPatternRepeated(s, pattern)) return true;
            }
        }
        return false;
    }

    private boolean isPatternRepeated(String str, String pattern) {
        return str.replace(pattern, "").isEmpty();
    }
}
