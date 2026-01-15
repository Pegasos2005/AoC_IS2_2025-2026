package software.ulpgc.aoc.reto08.command;

import software.ulpgc.aoc.reto08.model.Box;
import software.ulpgc.aoc.reto08.model.Conections;

import java.util.List;

public class CreateConectionsCommand {
    public Conections createConections(List<Box> boxes) {
        int n = boxes.size();
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        return new Conections(parent, size);
    }
}
