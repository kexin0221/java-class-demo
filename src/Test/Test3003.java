package Test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Test3003 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		ImageView imageView = new ImageView("file:image/china.gif");
		pane.getChildren().add(imageView);
		imageView.setLayoutX(20);
		imageView.setLayoutY(200);
		new Thread(() -> {
			try {
				while (true) {
					Platform.runLater(() -> {
						if(imageView.getLayoutY() >= 5) {
							imageView.setLayoutY(imageView.getLayoutY() - 5);
						} else {
							imageView.setLayoutY(200);
						}
					});
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
