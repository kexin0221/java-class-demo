package myCode;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class demo16_14 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Programming is fun");
        label.setStyle("-fx-font-size: 48");

        ComboBox<String> fontName = new ComboBox<>();
        fontName.setItems(FXCollections.observableArrayList(Font.getFontNames()));
        fontName.setValue("System");

        ComboBox<Integer> fontSize = new ComboBox<>();
        for (int i = 1; i <= 100; i++) {
            fontSize.getItems().add(i);
        }
        fontSize.setValue(48);

        CheckBox bold = new CheckBox("Bold");
        CheckBox italic = new CheckBox("Italic");

        fontName.setOnAction(event -> updateFont(label, fontName.getValue(), fontSize.getValue(),
                bold.isSelected(), italic.isSelected()));
        fontSize.setOnAction(event -> updateFont(label, fontName.getValue(), fontSize.getValue(),
                bold.isSelected(), italic.isSelected()));
        bold.setOnAction(event -> updateFont(label, fontName.getValue(), fontSize.getValue(),
                bold.isSelected(), italic.isSelected()));
        italic.setOnAction(event -> updateFont(label, fontName.getValue(), fontSize.getValue(),
                bold.isSelected(), italic.isSelected()));

        HBox nameBox = new HBox(5, new Label("Font Name"), fontName);
        HBox sizeBox = new HBox(5, new Label("Font Size"), fontSize);
        HBox setBox = new HBox(10, nameBox, sizeBox);
        HBox checkBox = new HBox(10, bold, italic);
        checkBox.setAlignment(Pos.CENTER);

        VBox pane = new VBox(10, setBox, label, checkBox);
        pane.setStyle("-fx-padding: 20");

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Exersice16_14");
        primaryStage.show();
    }

    private void updateFont(Label label, String name, int size, boolean bold, boolean italic) {
        String style = "-fx-font-family: '" + name + "'; -fx-font-size: " + size + ";";
        if (bold) style += "-fx-font-weight: bold;";
        if (italic) style += "-fx-font-style: italic";
        label.setStyle(style);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
