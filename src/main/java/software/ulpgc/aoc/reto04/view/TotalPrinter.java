package software.ulpgc.aoc.reto04.view;

public class TotalPrinter implements Printer {
    public void printTotal(long total) {
        System.out.println("Nº de rollos accesibles: " + total);
    }
}
