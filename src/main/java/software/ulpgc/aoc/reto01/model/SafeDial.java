package software.ulpgc.aoc.reto01.model;

public class SafeDial {
    private int position;
    private static final int MAX_VALUE = 100;

    public SafeDial(int initialPosition) {
        this.position = initialPosition;
    }

    public int rotateRightAndCount(int distance) {
        int zerosHit = 0;
        for (int i = 0; i < distance; i++) {
            position = (position + 1) % MAX_VALUE;
            if (isAtZero()) zerosHit++;
        }
        return zerosHit;
    }

    public int rotateLeftAndCount(int distance) {
        int zerosHit = 0;
        for (int i = 0; i < distance; i++) {
            position = (position - 1 + MAX_VALUE) % MAX_VALUE;
            if (isAtZero()) zerosHit++;
        }
        return zerosHit;
    }

    public boolean isAtZero() {
        return this.position == 0;
    }

    public int getDial() { return position; }
}
