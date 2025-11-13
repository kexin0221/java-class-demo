package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test1412 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        int width=150;
        int height=50;
        Pane pane=new Pane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

        Rectangle r1=new Rectangle(0,0,0,0);
        r1.layoutYProperty().bind(pane.heightProperty().divide(5).multiply(3));
        r1.heightProperty().bind(pane.heightProperty().divide(5).multiply(2));
        r1.widthProperty().bind(pane.widthProperty().subtract(15).divide(4));
        r1.setFill(Color.RED);
        Text t1=new Text(0,0,"��Ŀ--20%");
        t1.layoutYProperty().bind(pane.heightProperty().divide(5).multiply(3).subtract(15));
        t1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));


        Rectangle r2=new Rectangle(0,0,0,0);
        r2.layoutYProperty().bind(pane.heightProperty().divide(5).multiply(4));
        r2.layoutXProperty().bind(pane.widthProperty().subtract(15).divide(4).add(5));
        r2.heightProperty().bind(pane.heightProperty().divide(5));
        r2.widthProperty().bind(pane.widthProperty().subtract(15).divide(4));
        r2.setFill(Color.BLUE);
        Text t2=new Text(0,0,"����--10%");
        t2.layoutYProperty().bind(pane.heightProperty().divide(5).multiply(4).subtract(15));
        t2.layoutXProperty().bind(pane.widthProperty().subtract(15).divide(4).add(5));
        t2.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));

        Rectangle r3=new Rectangle(0,0,0,0);
        r3.layoutYProperty().bind(pane.heightProperty().divide(5).multiply(2));
        r3.layoutXProperty().bind(pane.widthProperty().subtract(15).divide(4).multiply(2).add(10));
        r3.heightProperty().bind(pane.heightProperty().divide(5).multiply(3));
        r3.widthProperty().bind(pane.widthProperty().subtract(15).divide(4));
        r3.setFill(Color.GREEN);
        Text t3=new Text(0,0,"���п���--30%");
        t3.layoutYProperty().bind(pane.heightProperty().divide(5).multiply(2).subtract(15));
        t3.layoutXProperty().bind(pane.widthProperty().subtract(15).divide(4).multiply(2).add(10));
        t3.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));


        Rectangle r4=new Rectangle(0,0,0,0);
        r4.layoutYProperty().bind(pane.heightProperty().divide(5).multiply(1));
        r4.layoutXProperty().bind(pane.widthProperty().subtract(15).divide(4).multiply(3).add(15));
        r4.heightProperty().bind(pane.heightProperty().divide(5).multiply(4));
        r4.widthProperty().bind(pane.widthProperty().subtract(15).divide(4).multiply(3).add(10));
        r4.setFill(Color.ORANGE);
        Text t4=new Text(0,0,"��ĩ����--40%");
        t4.layoutYProperty().bind(pane.heightProperty().divide(5).multiply(1).subtract(15));
        t4.layoutXProperty().bind(pane.widthProperty().subtract(15).divide(4).multiply(3).add(15));
        t4.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));

        pane.getChildren().add(r1);
        pane.getChildren().add(r2);
        pane.getChildren().add(r3);
        pane.getChildren().add(r4);
        pane.getChildren().add(t1);
        pane.getChildren().add(t2);
        pane.getChildren().add(t3);
        pane.getChildren().add(t4);

        Scene scene = new Scene(pane,500,300);
        primaryStage.setTitle("ShowImage"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

}
