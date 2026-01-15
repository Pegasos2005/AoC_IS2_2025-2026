package software.ulpgc.aoc.reto01.view;

public class TotalPrinter implements Printer {
    public void printTotal(long total) {
        System.out.printf("Nº de veces acabadas en 0: %d%n", total);
    }
}
