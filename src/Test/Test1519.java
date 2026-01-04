package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test1519 extends Application {
    int count = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        double width = pane.getWidth();
        double height = pane.getHeight();
        double x = Math.random() * (width - 20) + 10.0;
        double y = Math.random() * (height - 20) + 10.0;

        Circle c = new Circle(x, y,10);
        c.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));

        pane.getChildren().add(c);
        long begin = System.currentTimeMillis();
        c.setOnMouseClicked(e -> {
            double x1 = Math.random() * (pane.getWidth() - 20) + 10;
            double y1 = Math.random() * (pane.getHeight() - 20) + 10;
            c.setCenterX(x1);
            c.setCenterY(y1);
            c.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
            count++;
            if(count >= 20) {
                pane.getChildren().clear();
                Text t = new Text(100,100,"");
                t.setText("Time spent is " + (System.currentTimeMillis() - begin) +
                        " milliseconds.");
                pane.getChildren().add(t);
            }
        });
        Scene scene = new Scene(pane,450,200);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
