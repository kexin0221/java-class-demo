package Test;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test1519 extends Application {
	int count=0;
	int cc=0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane=new Pane();

		double width=pane.getWidth();
		double height=pane.getHeight();
		double x=Math.random()*(width-20)+10.0;
		double y=Math.random()*(height-20)+10.0;
		if(x<10)x=10;
		if(y<10)y=10;
		Circle c=new Circle(x,y,10);
		c.setFill(new Color(Math.random(),Math.random(),Math.random(),1));
		System.out.println(width);

		pane.getChildren().add(c);
		long begin=System.currentTimeMillis();
//		int count;
//		int count1=0;
//		Integer cc=0;
//		IntegerProperty count=new SimpleIntegerProperty(1);
		c.setOnMouseClicked(e ->{
			double x1 = Math.random() * (pane.getWidth() - 20) + 10;
			double y1 = Math.random() * (pane.getHeight() - 20) + 10;
//			System.out.println(x1);
			c.setCenterX(x1);
			c.setCenterY(y1);
			c.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
			count++;
//			cc=cc+1;
//			count.setValue(count.getValue()+1);;
//			System.out.println(count.getValue());
//			if(count.isEqualTo(20).getValue())
			if(count>=20)
			{
				pane.getChildren().clear();
				Text t=new Text(100,100,"");
				long spent=System.currentTimeMillis()-begin;
				t.setText("Time spent is "+spent+" milliseconds");
				pane.getChildren().add(t);
			}

		});

	Scene scene = new Scene(pane,450,200);
	primaryStage.setTitle("ShowImage"); // Set the stage title
	primaryStage.setScene(scene); // Place the scene in the stage
	primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
