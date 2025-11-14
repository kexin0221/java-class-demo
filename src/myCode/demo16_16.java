package myCode;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class demo16_16 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ComboBox<String> selectionCombo = new ComboBox<>();
        selectionCombo.getItems().addAll("SINGLE", "MULTIPLE");
        selectionCombo.setValue("SINGLE");

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Canada", "China", "Denmark", "France", "Germany",
                "India", "Norway", "United Kingdom", "United States of America");

        Label selectedLable = new Label("");

        selectionCombo.setOnAction(event -> {
            listView.getSelectionModel().clearSelection();
            selectedLable.setText("");
            if (selectionCombo.getValue().equals("SINGLE")) {
                listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            } else {
                listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (selectionCombo.getValue().equals("SINGLE")) {
                selectedLable.setText("Selected item is " + newValue);
            }
        });

        listView.getSelectionModel().getSelectedItems().addListener((
                javafx.collections.ListChangeListener.Change<? extends String> c) -> {
            if (!selectionCombo.getValue().equals("SINGLE")) {
                selectedLable.setText("Selected items are " + String.join(", ",
                        listView.getSelectionModel().getSelectedItems()));
            }
        });

        HBox hBox = new HBox(5, new Label("Choose Selection Mode: "), selectionCombo);
        VBox vBox = new VBox(10, hBox, listView, selectedLable);
        vBox.setPadding(new Insets(15));
        primaryStage.setScene(new Scene(vBox, 300, 250));
        primaryStage.setTitle("Exercise16_16");
        primaryStage.show();

        selectionCombo.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}