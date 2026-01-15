package software.ulpgc.aoc.reto08.controller;

import software.ulpgc.aoc.reto08.command.*;
import software.ulpgc.aoc.reto08.model.*;

import java.util.List;
import java.util.PriorityQueue;

public class CircuitController {
    private final Conections conections;
    private final List<Box> boxes;
    private int numCircuits;

    private CircuitController(List<Box> boxes) {
        this.boxes = boxes;
        this.numCircuits = boxes.size();
        this.conections = new CreateConectionsCommand().createConections(boxes);
    }

    public static CircuitController createCircuitManager(List<Box> boxes) {
        return new CircuitController(boxes);
    }

    public void calculateContections() {
        PriorityQueue<Edge> nearConections = new CalculateConectionsCommand().calculateConections(boxes);
        UniteConectionsCommand uniter = new UniteConectionsCommand(conections);

        // 3. Procesar EXACTAMENTE las 1000 conexiones más cortas
        for (int i = 0; i < 1000 && !nearConections.isEmpty(); i++) {
            Edge edge = nearConections.poll();
            uniter.execute(edge.id1(), edge.id2());
        }
    }

    public long getThreeLargestCircuitsProduct() {
        return new ThreeLargestCircuitsCommand(conections).execute();
    }

    public long calculateLargeConection() {
        PriorityQueue<Edge> nearConections = new CalculateConectionsCommand().calculateConections(boxes);
        UniteOneConecCommand uniter = new UniteOneConecCommand(conections);
        Box lastBox1 = null;
        Box lastBox2 = null;

        while (!nearConections.isEmpty() && numCircuits > 1) {
            Edge edge = nearConections.poll();

            // Si unite devuelve true, es q esta conexión ha unido dos grupos
            if (uniter.execute(edge.id1(), edge.id2())) {
                numCircuits--;
                // Si acabamos de llegar a 1 circuito, esta fue la última conexión necesaria
                if (numCircuits == 1) {
                    lastBox1 = boxes.get(edge.id1());
                    lastBox2 = boxes.get(edge.id2());
                }
            }
        }

        return (long) lastBox1.x() * lastBox2.x();
    }
}