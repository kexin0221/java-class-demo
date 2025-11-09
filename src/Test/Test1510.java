package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test1510 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane=new Pane();
		Text text= new Text(100,100,"");

		pane.getChildren().add(text);

		Scene scene = new Scene(pane,450,200);
		primaryStage.setTitle("ShowImage"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();

		StringBuffer value=new StringBuffer();

		text.setOnKeyPressed(e -> {
			if(e.getCode()==KeyCode.ENTER)
			{
				text.setText(value.toString());
				value.delete(0, value.length());
			}
			else
			{
				value.append(e.getText());
				text.setText(value.toString());
			}
		});
		text.requestFocus();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
