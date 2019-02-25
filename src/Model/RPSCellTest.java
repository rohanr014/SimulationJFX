package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RPSCellTest {
    private Cell rockCell;
    private Cell paperCell;
    private Cell scissorCell;
    private List<Cell> neighbors;


    @BeforeEach
    void setUp() {
        rockCell = new RPSCell(1, 1, 0, 1, 1);
        paperCell = new RPSCell(1, 1, 1, 1, 1);
        scissorCell = new RPSCell(1, 1, 2, 1, 1);
        neighbors = new ArrayList<>();
    }

    @Test
    void rockToPaper() {
        for(int i=0; i<5; i++){
            neighbors.add(paperCell);
        }
        neighbors.add(rockCell);
        neighbors.add(scissorCell);
        rockCell.updateCell(neighbors);

        var expected = 1;
        var actual = rockCell.myNextState;
        assertEquals(expected, actual);
    }

    @Test
    void paperToScissor() {
        for(int i=0; i<4; i++){
            neighbors.add(scissorCell);
        }
        for(int i=0; i<3; i++){
            neighbors.add(paperCell);
        }
        neighbors.add(rockCell);
        paperCell.updateCell(neighbors);

        var expected = 2;
        var actual = paperCell.myNextState;
        assertEquals(expected, actual);
    }
}