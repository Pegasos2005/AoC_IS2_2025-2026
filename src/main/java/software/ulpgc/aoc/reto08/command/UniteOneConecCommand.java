package software.ulpgc.aoc.reto08.command;

import software.ulpgc.aoc.reto08.model.Conections;

public class UniteOneConecCommand {
    private final Conections conections;
    public UniteOneConecCommand(Conections conections) {
        this.conections = conections;
    }

    // Busca el "representante" del circuito con Path Compression
    private int find(int i) {
        if (conections.parent()[i] == i) return i;
        return conections.parent()[i] = find(conections.parent()[i]);
    }

    // Une dos circuitos si no están ya conectados
    public boolean execute(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            // Unión por tamaño para mantener el árbol balanceado
            if (conections.size()[rootI] < conections.size()[rootJ]) {
                conections.parent()[rootI] = rootJ;
                conections.size()[rootJ] += conections.size()[rootI];
            } else {
                conections.parent()[rootJ] = rootI;
                conections.size()[rootI] += conections.size()[rootJ];
            }
            return true;
        }
        return false;
    }
}
