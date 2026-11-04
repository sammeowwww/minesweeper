package minesweeper.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Field {
    private ArrayList<Square> squares;
    private int dimension;

    public Field(int dimension) {
        this.dimension = dimension;

        if (dimension <= 0) {
            throw new IllegalArgumentException("dimension must be positive");
        }

        squares = new ArrayList<>();
        Set<Integer> bombPositions = chooseBombPositions(dimension);
            createSquares(dimension, bombPositions);
    }

    private Set<Integer> chooseBombPositions(int dimension) {
        int squareCount = dimension * dimension;
        int bombCount = (int) Math.round(squareCount * 0.15);
        Random random = new Random();
        Set<Integer> bombPositions = new HashSet<>();

        while (bombPositions.size() < bombCount) {
            bombPositions.add(random.nextInt(squareCount));
        }

        return bombPositions;
    }

    private void createSquares(int dimension, Set<Integer> bombPositions) {
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                int position = row * dimension + col;
                squares.add(new Square(row, col, bombPositions.contains(position)));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public Square getSquare(int row, int col) throws IllegalArgumentException {
        if (row < 0 || row >= dimension || col < 0 || col >= dimension) {
            throw new IllegalArgumentException("row and col must be between 0 and " + (dimension - 1));
        }
        return squares.get(row * dimension + col);
    }
}
