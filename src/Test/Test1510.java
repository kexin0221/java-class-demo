package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test1510 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Text text = new Text(100,100,"");

        pane.getChildren().add(text);

        Scene scene = new Scene(pane,450,200);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();

        StringBuffer value = new StringBuffer();

        text.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                text.setText(value.toString());
                value.delete(0, value.length());
            } else {
                value.append(e.getText());
                text.setText(value.toString());
            }
        });
        text.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
