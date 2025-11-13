package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test1503 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        BorderPane bp=new BorderPane();
        Pane p=new Pane();
        HBox hb=new HBox();
        hb.setAlignment(Pos.TOP_CENTER);
        hb.setSpacing(5);
        hb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

        bp.setCenter(p);
        bp.setBottom(hb);

        Circle c=new Circle(100,100,60);
        p.getChildren().add(c);

        Button left=new Button("Left");
        left.setOnAction(e ->{
            double remain=c.getCenterX()-5;
            c.setCenterX(Math.max(remain, c.getRadius()));
        });
        hb.getChildren().add(left);

        Button right=new Button("right");
        right.setOnAction(e ->{
            double remain=c.getCenterX()+5;
            c.setCenterX(Math.min(remain, p.getWidth() - c.getRadius()));
        });
        hb.getChildren().add(right);

        Button up=new Button("up");
        up.setOnAction(e ->{
            double remain=c.getCenterY()-5;
            c.setCenterY(Math.max(remain, c.getRadius()));
        });
        hb.getChildren().add(up);

        Button down=new Button("down");
        down.setOnAction(e ->{
            double remain=c.getCenterY()+5;
            c.setCenterY(Math.min(remain, p.getHeight() - c.getRadius()));
        });
        hb.getChildren().add(down);

        Scene scene = new Scene(bp,300,300);
        primaryStage.setTitle("ShowImage"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

}
