import org.junit.jupiter.api.Test;
import software.ulpgc.aoc.reto01.command.*;
import software.ulpgc.aoc.reto01.controller.*;
import software.ulpgc.aoc.reto01.model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class Reto01Test {

    // TEST IO - SAFEDIAL

    @Test
    void testRightAndCount() {
        // Caso Normal: Movimiento simple sin dar la vuelta
        SafeDial dial = new SafeDial(50); // Empieza en 50
        int zeros = dial.rotateRightAndCount(310);
        assertEquals(60, dial.getDial());
        assertEquals(3, zeros);
    }

    @Test
    void testLeftAndCount() {
        // Caso Normal: Movimiento simple sin dar la vuelta
        SafeDial dial = new SafeDial(50); // Empieza en 50
        int zeros = dial.rotateLeftAndCount(310);
        assertEquals(40, dial.getDial());
        assertEquals(3, zeros);
    }

    // TEST COMMAND

    @Test
    void testRightRotation() {
        RotationCommand rotation = new RightRotation(349);
        int zeros = rotation.execute(new SafeDial(50));
        assertEquals(3, zeros);

        zeros = new RightRotation(350).execute(new SafeDial(50));
        assertEquals(4, zeros);
    }

    @Test
    void testLeftRotation() {
        RotationCommand rotation = new RightRotation(349);
        int zeros = rotation.execute(new SafeDial(50));
        assertEquals(3, zeros);

        zeros = new LeftRotation(350).execute(new SafeDial(50));
        assertEquals(4, zeros);
    }

    // TEST CONTROLLER

    @Test
    void testProcessTimesInZero() {
        List<String> moves = List.of("R50", "R1", "L1", "L300", "L50", "R542");
        long total = new DialController().processTimesInZero(moves, 50);
        assertEquals(3, total);

        moves = List.of("R48", "R1", "L1", "L97", "R49");
        total = new DialController().processTimesInZero(moves, 50);
        assertEquals(0, total);
    }

    @Test
    void testProcessTimesByZero() {
        List<String> moves = List.of("R50", "R1", "L1", "L300", "L50", "R542");
        long total = new DialController().processTimesByZero(moves, 50);
        assertEquals(10, total);

        moves = List.of("R50", "R1", "L1", "L100", "L50", "R42");
        total = new DialController().processTimesByZero(moves, 50);
        assertEquals(3, total);

        moves = List.of("R48", "R1", "L1", "L97", "R49");
        total = new DialController().processTimesByZero(moves, 50);
        assertEquals(0, total);
    }
}
