package Test;

import javafx.application.Application;
import javafx.application.Platform;
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

import static java.lang.Thread.sleep;

public class Test3005 extends Application {

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

		FanTask fanTask = new FanTask(pane);
		new Thread(fanTask).start();

		Button b1 = new Button("Pause");
		b1.setOnAction(e -> fanTask.pause());
		hb.getChildren().add(b1);

		Button b2 = new Button("Resume");
		b2.setOnAction(e -> fanTask.play());
		hb.getChildren().add(b2);

		Button b3 = new Button("Reverse");
		b3.setOnAction(e -> fanTask.reverse());
		hb.getChildren().add(b3);

		Scene scene = new Scene(bp,300,250);
		primaryStage.setTitle("ShowImage");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	private void getFan(Pane sp, int angle) {
		sp.getChildren().clear();
        Circle circle = new Circle(150,100,90);
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

	class FanTask implements Runnable {
		int count = 0;
		int reverse = 1;
		Pane pane;
		boolean play = true;
		public FanTask (Pane pane) {
			this.pane = pane;
		}

		public void run() {
			while(true) {
				if (play) {
					Platform.runLater(() -> getFan(pane, count));
				}
				count += 30 * reverse;
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
		}

		public void pause() {
			play = false;
		}

		public void play() {
			play = true;
		}

		public void reverse() {
			reverse *= -1;
		}
	}
}
