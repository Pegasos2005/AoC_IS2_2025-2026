package software.ulpgc.aoc.reto08.view;

public class TotalPrinter implements Printer {
    public void printTotal(long total) {
        System.out.println("Producto de los 3 circuitos más grandes: " + total);
    }
}
