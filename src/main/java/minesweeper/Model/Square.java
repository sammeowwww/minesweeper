package minesweeper.Model;

public class Square {
    private int row;
    private int col;
    private boolean flag;
    private boolean hasBomb;

    public Square(int row, int col, boolean hasBomb) {
        this.row = row;
        this.col = col;
        this.hasBomb = hasBomb;
    }

    public void setFlag() {
        flag = true;
        // calls the UI to set the flag
    }

    public boolean hasBomb() {
        return hasBomb;
    }

    public boolean isFlaged() {
        return flag;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void toggleFlag() {
        flag = !flag;
    }

    @Override
    public String toString() {
        return row + " " + col;
    }
}
