package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test1502 extends Application {
	int i=1;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane bp=new BorderPane();
		StackPane spC=new StackPane();
		StackPane spB=new StackPane();

		bp.setCenter(spC);
		bp.setBottom(spB);

		Rectangle r=new Rectangle(100,100,150,100);
		r.setFill(Color.WHITE);
		r.setStroke(Color.BLACK);
		spC.getChildren().add(r);

		Button but=new Button("Rotate");

		but.setOnAction(e -> {
			r.setRotate(r.getRotate()+15);
//			r.setRotate(i*15);
//			i++;
		});

		spB.getChildren().add(but);

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
