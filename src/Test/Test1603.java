package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test1603 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        StackPane sp = new StackPane();
        sp.setAlignment(Pos.CENTER);
        HBox hb = new HBox();
        hb.setAlignment(Pos.TOP_CENTER);
        hb.setSpacing(5);
        bp.setCenter(sp);
        bp.setBottom(hb);

        Scene scene = new Scene(bp,300,250);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();

        VBox vb = new VBox();
        vb.setSpacing(10);
        vb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        Circle c = new Circle(0,0,20);
        Circle c1 = new Circle(0,0,20);
        Circle c2 = new Circle(0,0,20);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);
        c1.setFill(Color.WHITE);
        c1.setStroke(Color.BLACK);
        c2.setFill(Color.WHITE);
        c2.setStroke(Color.BLACK);
        vb.getChildren().addAll(c,c1,c2);
        Label label = new Label("",vb);
        label.setStyle("-fx-border-color:black");
        sp.getChildren().add(label);

        RadioButton rbRed = new RadioButton("Red") ;
        RadioButton rbYellow = new RadioButton("Yellow") ;
        RadioButton rbGreen = new RadioButton("Green") ;
        hb.getChildren().addAll(rbRed,rbYellow,rbGreen);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbYellow.setToggleGroup(group);

        rbRed.setOnAction(e-> {
            c.setFill(Color.RED);
            c1.setFill(Color.WHITE);
            c2.setFill(Color.WHITE);
        });

        rbYellow.setOnAction(e-> {
            c.setFill(Color.WHITE);
            c1.setFill(Color.YELLOW);
            c2.setFill(Color.WHITE);
        });

        rbGreen.setOnAction(e-> {
            c.setFill(Color.WHITE);
            c1.setFill(Color.WHITE);
            c2.setFill(Color.GREEN);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
