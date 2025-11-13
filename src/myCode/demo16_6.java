package myCode;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class demo16_6 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField("JavaFX");
        textField.setPrefColumnCount(12);

        ToggleGroup group = new ToggleGroup();
        RadioButton left = new RadioButton("Left");
        RadioButton center = new RadioButton("Center");
        RadioButton right = new RadioButton("Right");

        left.setToggleGroup(group);
        center.setToggleGroup(group);
        right.setToggleGroup(group);
        center.setSelected(true);

        TextField columnSize = new TextField("12");
        columnSize.setPrefColumnCount(5);

        left.setOnAction(event -> textField.setAlignment(Pos.BASELINE_LEFT));
        center.setOnAction(event -> textField.setAlignment(Pos.BASELINE_CENTER));
        right.setOnAction(event -> textField.setAlignment(Pos.BOTTOM_RIGHT));
        columnSize.setOnAction(event -> {
            try {
                textField.setPrefColumnCount(Integer.parseInt(columnSize.getText()));
            } catch (NumberFormatException ignored) {}
        });

        HBox radioBox = new HBox(10, left, center, right);
        HBox columnBox = new HBox(5, new Label("Column SIze"), columnSize);
        HBox controls = new HBox(20, radioBox, columnBox);
        HBox textFields = new HBox(20, new Label("Text Field"), textField);

        VBox pane = new VBox(10, textFields, controls);
        pane.setStyle("-fx-padding: 20");

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Exercise16_06");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
