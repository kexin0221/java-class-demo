package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Test1410 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane,500,300);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();

        double width = pane.getWidth();
        double height = pane.getHeight();

        Ellipse e1 = new Ellipse(width / 2, height / 4,
                width / 4, height / 8);
        e1.setStroke(Color.BLACK);
        e1.setFill(Color.WHITE);

        Line line1 = new Line(width / 4, height / 4,
                width / 4, 3 * height / 4);
        Line line2 = new Line(3 * width / 4, height / 4,
                3 * width / 4, 3 * height / 4);

        Arc arc1 = new Arc(width / 2, 3 * height / 4,
                width / 4, height / 8, 180, 180);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);

        pane.getChildren().addAll(e1, line1, line2, arc1);

        Arc arc2 = new Arc(width / 2, 3 * height / 4,
                width / 4, height / 8, 0, 180);
        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.WHITE);
        arc2.setStroke(Color.BLACK);
        arc2.getStrokeDashArray().addAll(6.0, 21.0);
        pane.getChildren().add(arc2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
