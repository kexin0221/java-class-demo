package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Test1404 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FlowPane pane = new FlowPane();

		pane.setPadding(new Insets(50, 12.5, 13.5, 14.5));
		pane.setHgap(20);
		pane.setVgap(5.5);
		pane.setStyle("-fx-background-color: white");
		Font f1 = Font.font("TimesRomes", FontWeight.BOLD, FontPosture.ITALIC, 22);
		for (int i = 0; i < 5; i++) {
			Label label = new Label("Java");
			label.setFont(f1);
			label.setRotate(90);

			Color c=new Color(Math.random(), Math.random(), Math.random(), Math.random());
			label.setTextFill(c);
			pane.getChildren().add(label);
		}


		Scene scene = new Scene(pane, 360, 150);
		primaryStage.setTitle("ShowImage"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
