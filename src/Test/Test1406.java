package Test;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test1406 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        int width=50;

        Rectangle temp=null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    temp = new Rectangle(width, width, Color.WHITE);
                } else {
                    temp = new Rectangle(width, width, Color.BLACK);
                }
                temp.widthProperty().bind(pane.widthProperty().divide(8));
                temp.heightProperty().bind(pane.heightProperty().divide(8));
                pane.add(temp, i, j);
            }
            Scene scene = new Scene(pane, 400, 400);
            primaryStage.setTitle("ShowImage"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show(); // Display the stage
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

}
