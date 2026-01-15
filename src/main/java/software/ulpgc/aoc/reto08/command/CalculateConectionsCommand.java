package software.ulpgc.aoc.reto08.command;

import software.ulpgc.aoc.reto08.model.Box;
import software.ulpgc.aoc.reto08.model.Edge;

import java.util.List;
import java.util.PriorityQueue;

public class CalculateConectionsCommand {
    public PriorityQueue<Edge> calculateConections(List<Box> boxes) {
        // 2. Calcular todas las posibles conexiones (Aristas)
        int n = boxes.size();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Box b1 = boxes.get(i);
                Box b2 = boxes.get(j);
                pq.add(new Edge(b1.id(), b2.id(), b1.dist(b2)));
            }
        }

        return pq;

    }
}
