package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test1606 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vb=new VBox();
		vb.setAlignment(Pos.TOP_CENTER);
		vb.setPadding(new Insets(15, 15, 15, 15));
		vb.setSpacing(15);
		TextField tf = new TextField();
		Label  label=new Label("TextField",tf);
		label.setContentDisplay(ContentDisplay.RIGHT);
		vb.getChildren().add(label);
		
//		tf.setPrefColumnCount(1);
		HBox hb=new HBox();
		hb.setAlignment(Pos.BOTTOM_LEFT);
		hb.setSpacing(10);
		vb.getChildren().add(hb);
		
		RadioButton rbLeft = new RadioButton("Left");
    RadioButton rbCenter = new RadioButton("Center");
    RadioButton rbRight = new RadioButton("Right");
		
    ToggleGroup group = new ToggleGroup();
    rbLeft.setToggleGroup(group);
    rbCenter.setToggleGroup(group);
    rbRight.setToggleGroup(group);
    
    rbLeft.setOnAction(e-> tf.setAlignment(Pos.BOTTOM_LEFT));
    rbCenter.setOnAction(e-> tf.setAlignment(Pos.BOTTOM_CENTER));
    rbRight.setOnAction(e-> tf.setAlignment(Pos.BOTTOM_RIGHT));
    
    hb.getChildren().addAll(rbLeft,rbCenter, rbRight);    

    
    TextField tf1 = new TextField();
    tf1.setPrefColumnCount(5);
    Label  label1=new Label("Column Size",tf1);
    label1.setContentDisplay(ContentDisplay.RIGHT);
    
    tf1.setOnAction(e->tf.setPrefColumnCount(Integer.valueOf(tf1.getText())));
    hb.getChildren().add(label1);
    
    
		Scene scene = new Scene(vb,550,150);
		primaryStage.setTitle("ShowImage"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
