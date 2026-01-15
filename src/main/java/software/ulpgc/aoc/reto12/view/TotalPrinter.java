package software.ulpgc.aoc.reto12.view;

public class TotalPrinter implements Printer {
    @Override
    public void print(long total) {
        System.out.printf("Resultado: %d%n", total);
    }
}