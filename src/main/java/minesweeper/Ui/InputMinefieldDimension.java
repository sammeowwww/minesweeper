package minesweeper.Ui;

import java.util.function.IntConsumer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class InputMinefieldDimension {

    public Scene createScene(IntConsumer onDimensionChosen) {
        Label prompt = new Label("Enter dimension of Minefield. Eg. D x D");
        TextField dimensionInput = new TextField("10");
        dimensionInput.setMaxWidth(160);

        Button startButton = new Button("Start Minesweeper");
        Label errorMessage = new Label();
        startButton.setOnAction(event ->
                submitDimension(dimensionInput.getText(), errorMessage, onDimensionChosen));

        VBox root = new VBox(12, prompt, dimensionInput, startButton, errorMessage);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 400);
    }

    private void submitDimension(String text, Label errorMessage, IntConsumer onDimensionChosen) {
        Integer dimension = parsePositiveDimension(text);
        if (dimension == null) {
            errorMessage.setText("Enter a positive whole number.");
            return;
        }

        errorMessage.setText("");
        onDimensionChosen.accept(dimension);
    }

    private Integer parsePositiveDimension(String text) {
        try {
            int dimension = Integer.parseInt(text.trim());
            return dimension > 0 ? dimension : null;
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
