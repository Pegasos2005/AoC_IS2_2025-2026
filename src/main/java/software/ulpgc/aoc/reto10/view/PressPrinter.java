package software.ulpgc.aoc.reto10.view;

public class PressPrinter implements Printer {
    public void showResult(long total) {
        System.out.println("La cantidad óptima de veces que se pueden pulsar los botones es: " + total + " veces.");
    }
}
