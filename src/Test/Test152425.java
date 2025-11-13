package Test;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test152425 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Pane pane=new Pane();
        Circle circle=new Circle(150,100,15);
        circle.setFill(Color.BLUE);

        Arc arc = new Arc(250, 100, 200, 200, 210, 120);
        arc.setStroke(Color.RED); // Set fill color
        arc.setFill(Color.WHITE);
        arc.setType(ArcType.OPEN);
        pane.getChildren().addAll(arc,circle);

        FadeTransition ft = new FadeTransition(Duration.millis(3000), circle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setByValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(2000));
        pt.setPath(arc);
        pt.setNode(circle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play(); // Start animation

        pane.setOnMousePressed(e->{ft.pause();pt.pause();});
        pane.setOnMouseReleased(e->{ft.play();pt.play();});

        Scene scene = new Scene(pane,500,350);
        primaryStage.setTitle("ShowImage"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

}
