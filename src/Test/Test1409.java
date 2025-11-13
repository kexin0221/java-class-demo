package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test1409 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        pane.add(getFan(), 0, 0);
        pane.add(getFan(), 0, 1);
        pane.add(getFan(), 1, 0);
        pane.add(getFan(), 1, 1);
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }

    private Pane getFan() {
        Pane pane = new Pane();
        Circle circle=new Circle(100,100,90);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);
        for(int i = 0; i < 4; i++) {
            Arc arc = new Arc(100, 100, 80, 80, 30 + i*90, 30);
            arc.setFill(Color.RED); // Set fill color
            arc.setType(ArcType.ROUND);
            pane.getChildren().add(arc);
        }
        return pane;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

}
