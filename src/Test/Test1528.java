package Test;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test1528 extends Application {
    int count = 30;
    int reverse = 1;
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        Pane pane = new Pane();
        HBox hb = new HBox();
        hb.setAlignment(Pos.TOP_CENTER);
        hb.setSpacing(5);
        hb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

        bp.setCenter(pane);
        bp.setBottom(hb);

        EventHandler<ActionEvent> eventHandler = e -> {
            getFan(pane, count);
            count += 30 * reverse;
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100),
                eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Button b1 = new Button("Pause");
        b1.setOnAction(e -> animation.pause());
        hb.getChildren().add(b1);

        Button b2 = new Button("Resume");
        b2.setOnAction(e -> animation.play());
        hb.getChildren().add(b2);

        Button b3 = new Button("Reverse");
        b3.setOnAction(e -> reverse *= -1);
        hb.getChildren().add(b3);

        Scene scene = new Scene(bp,300,250);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void getFan(Pane sp, int angle) {
        sp.getChildren().clear();
        Circle circle = new Circle(150, 100, 90);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        sp.getChildren().add(circle);
        for(int i = 0; i < 4; i++) {
            Arc arc = new Arc(150, 100, 80, 80,
                    angle + i * 90, 30);
            arc.setFill(Color.RED);
            arc.setType(ArcType.ROUND);
            sp.getChildren().add(arc);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
