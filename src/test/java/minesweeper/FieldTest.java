package minesweeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import minesweeper.Model.Field;
import minesweeper.Model.Square;

class FieldTest {

    @Test
    void createsExactlyFifteenBombsOnTenByTenField() {
        Field field = new Field(10);

        int bombCount = 0;
        for (int row = 0; row < field.getDimension(); row++) {
            for (int col = 0; col < field.getDimension(); col++) {
                Square square = field.getSquare(row, col);
                assertEquals(row, square.getRow());
                assertEquals(col, square.getCol());
                if (square.hasBomb()) {
                    bombCount++;
                }
            }
        }

        assertEquals(15, bombCount);
    }

    @Test
    void rejectsCoordinatesOutsideTheField() {
        Field field = new Field(10);

        assertThrows(IllegalArgumentException.class, () -> field.getSquare(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> field.getSquare(0, 10));
    }
}
