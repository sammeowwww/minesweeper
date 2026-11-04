package minesweeper;

import minesweeper.Model.Field;
import minesweeper.Model.Square;

public class Logic {
    private Field field;

    public Logic(Field field) {
        this.field = field;
    }

    public void toggleFlag(Square square) {
        square.toggleFlag();
    }

    /**
     * Finds the number of bombs surrounding that particular square.
     * @param square the square whose neighbors are checked
     * @return number of bombs surrounding the square
     */
    public int findSurroundingBombs(Square square) {
        int row = square.getRow();
        int col = square.getCol();
        int count = 0;

        for (int neighborRow = row - 1; neighborRow <= row + 1; neighborRow++) {
            for (int neighborCol = col - 1; neighborCol <= col + 1; neighborCol++) {
                if (neighborRow == row && neighborCol == col) {
                    continue;
                }
                if (!isWithinField(neighborRow, neighborCol)) {
                    continue;
                }
                if (field.getSquare(neighborRow, neighborCol).hasBomb()) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isWithinField(int row, int col) {
        return row >= 0 && row < field.getDimension()
                && col >= 0 && col < field.getDimension();
    }


}
