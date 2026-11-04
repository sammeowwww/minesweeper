package minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;
import minesweeper.Model.Field;
import minesweeper.Ui.GameBoard;
import minesweeper.Ui.InputMinefieldDimension;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Minesweeper");
        InputMinefieldDimension inputScreen = new InputMinefieldDimension();
        stage.setScene(inputScreen.createScene(dimension -> {
            Field field = new Field(dimension);
            Logic logic = new Logic(field);
            GameBoard board = new GameBoard();
            stage.setScene(board.createScene(field, logic, stage));
        }));

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
