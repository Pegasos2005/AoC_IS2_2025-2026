package software.ulpgc.aoc.reto02.view;

public class TotalPrinter implements Printer {
    public void printTotal(long total) {
        System.out.printf("Suma total de IDs inválidos: %d%n", total);
    }
}
