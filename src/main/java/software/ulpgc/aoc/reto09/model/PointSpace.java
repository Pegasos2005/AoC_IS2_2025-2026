package software.ulpgc.aoc.reto09.model;

import java.awt.*;
import java.util.List;

public class PointSpace {
    private final List<Point> points;
    private final Polygon boundary; // Para optimizar cálculos de inclusión (Parte 2)

    public PointSpace(List<Point> points) {
        this.points = points;
        this.boundary = new Polygon();
        points.forEach(p -> boundary.addPoint(p.x(), p.y()));
    }

    public int size() {
        return points.size();
    }

    public Point get(int index) {
        return points.get(index);
    }



    // Lógica geométrica: Verifica si el centro de un rectángulo candidato está dentro del polígono general
    public boolean containsCenter(double cx, double cy) {
        return boundary.contains(cx, cy);
    }

    // Lógica geométrica: Verifica colisiones con "paredes" formadas por los puntos (Parte 2)
    public boolean intersectsWalls(int minX, int maxX, int minY, int maxY) {
        int n = points.size();
        for (int i = 0; i < n; i++) {
            Point a = points.get(i);
            Point b = points.get((i + 1) % n); // Arista entre punto actual y siguiente

            // Pared Vertical
            if (a.x() == b.x()) {
                int wallX = a.x();
                if (wallX > minX && wallX < maxX) {
                    int wallY1 = Math.min(a.y(), b.y());
                    int wallY2 = Math.max(a.y(), b.y());
                    if (wallY1 < maxY && wallY2 > minY) return true; // Colisión
                }
            }
            // Pared Horizontal
            else if (a.y() == b.y()) {
                int wallY = a.y();
                if (wallY > minY && wallY < maxY) {
                    int wallX1 = Math.min(a.x(), b.x());
                    int wallX2 = Math.max(a.x(), b.x());
                    if (wallX1 < maxX && wallX2 > minX) return true; // Colisión
                }
            }
        }
        return false;
    }

}
