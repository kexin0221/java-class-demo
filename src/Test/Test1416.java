package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Test1416 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();

		Line l1 = new Line(0,0,0,0);
		Line l2 = new Line(0,0,0,0);
		Line l3 = new Line(0,0,0,0);
		Line l4 = new Line(0,0,0,0);

		l1.startYProperty().bind(pane.heightProperty().divide(3));
		l1.endYProperty().bind(pane.heightProperty().divide(3));
		l1.endXProperty().bind(pane.widthProperty());
		l2.startYProperty().bind(pane.heightProperty().divide(3).multiply(2));
		l2.endYProperty().bind(pane.heightProperty().divide(3).multiply(2));
		l2.endXProperty().bind(pane.widthProperty());
		l1.setStroke(Color.BLUE);
		l2.setStroke(Color.BLUE);

		l3.startXProperty().bind(pane.widthProperty().divide(3));
		l3.endXProperty().bind(pane.widthProperty().divide(3));
		l3.endYProperty().bind(pane.heightProperty());
		l4.startXProperty().bind(pane.widthProperty().divide(3).multiply(2));
		l4.endXProperty().bind(pane.widthProperty().divide(3).multiply(2));
		l4.endYProperty().bind(pane.heightProperty());
		l3.setStroke(Color.RED);
		l4.setStroke(Color.RED);

		pane.getChildren().add(l1);
		pane.getChildren().add(l2);
		pane.getChildren().add(l3);
		pane.getChildren().add(l4);

		Scene scene = new Scene(pane,300,300);
		primaryStage.setTitle("ShowImage");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
