package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Test3001 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		TextArea ta=new TextArea();
		ta.setWrapText(true);
		ScrollPane sp=new ScrollPane(ta);
		StringBuffer sb=new StringBuffer();
		int times1=100;
		char a='a';
		Thread thread1 = new Thread(()->{
			for(int i=0;i<times1;i++)
			{
				sb.append(a);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		int times2=100;
		char b='b';
		Thread thread2 = new Thread(()->{
			for(int i=0;i<times2;i++)
			{
				sb.append(b);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		int num=100;
		Thread thread3 = new Thread(()->{
			for(int i=1;i<=num;i++)
			{
				sb.append(i);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		thread1.start();
		thread2.start();
		thread3.start();
		thread1.join();
		thread2.join();
		thread3.join();
		ta.setText(sb.toString());
		Scene scene = new Scene(sp,450,200);
		primaryStage.setTitle("ShowImage"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
