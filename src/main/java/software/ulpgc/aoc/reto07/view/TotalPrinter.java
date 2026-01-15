package software.ulpgc.aoc.reto07.view;

public class TotalPrinter implements Printer {
    public void printTotal(long total) {
        System.out.printf("Total de bifurcaciones detectadas: %d%n", total);
    }
}
