package myCode;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class demo30_3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        ImageView imageView = new ImageView("file:image/china.gif");
        pane.getChildren().add(imageView);

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PathTransition pathTransition = new PathTransition(Duration.millis(10000),
                    new Line(100, 200, 100, 0), imageView);
            pathTransition.setCycleCount(5);
            pathTransition.play();
        }).start();

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("FlagRisingAnimation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
