package minesweeper.Ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import minesweeper.Model.Field;
import minesweeper.Logic;
import minesweeper.Model.Square;

public class GameBoard {

    public Scene createScene(Field field, Logic logic, Stage stage) {
        GridPane board = new GridPane();
        for (int row = 0; row < field.getDimension(); row++) {
            for  (int col = 0; col < field.getDimension(); col++) {
                Square square = field.getSquare(row, col);
                Button cell = new Button();
                cell.setPrefSize(32, 32);

                cell.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        boolean hasBomb = square.hasBomb();
                        if (hasBomb) {
                            Label end = new Label("You have Lost");
                            Scene endgame = new Scene(end, 500, 400);
                            stage.setScene(endgame);
                        } else {
                            int numOfBombs = logic.findSurroundingBombs(square);
                            cell.setText(String.valueOf(numOfBombs));
                        }
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        logic.toggleFlag(square);
                        cell.setText(square.isFlaged() ? "F" : "");
                    }
                });

                board.add(cell, col, row);
            }
        }
        return new Scene(board);
    }
}
