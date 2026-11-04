package minesweeper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import minesweeper.Model.Field;

class LogicTest {

    @Test
    void countsOnlyTheThreeNeighborsOfTopLeftCorner() {
        Field field = new Field(10);
        Logic logic = new Logic(field);

        int expected = 0;
        if (field.getSquare(0, 1).hasBomb()) {
            expected++;
        }
        if (field.getSquare(1, 0).hasBomb()) {
            expected++;
        }
        if (field.getSquare(1, 1).hasBomb()) {
            expected++;
        }

        assertEquals(expected, logic.findSurroundingBombs(field.getSquare(0, 0)));
    }
}
