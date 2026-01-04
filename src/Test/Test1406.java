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
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Color color = ((i + j) % 2 == 0) ? Color.WHITE : Color.BLACK;
                Rectangle rect = new Rectangle(50, 50, color);

                rect.widthProperty().bind(pane.widthProperty().divide(8));
                rect.heightProperty().bind(pane.heightProperty().divide(8));

                pane.add(rect, i, j);
            }
            Scene scene = new Scene(pane, 400, 400);
            primaryStage.setTitle("ShowImage");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
