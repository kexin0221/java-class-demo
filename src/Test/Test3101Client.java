package Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Test3101Client extends Application {
	DataOutputStream toServer = null;
  DataInputStream fromServer = null;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FlowPane fp=new FlowPane();
		Label rate=new Label("Annual Month Rate");
		TextField tfRate=new TextField();
		Label year=new Label("Number of Years");
		TextField tfYear=new TextField();
		Button submit=new Button("submit");
		Label loan=new Label("Loan Amount");
		TextField tfLoan=new TextField();

		TextArea ta=new TextArea();
		ScrollPane sp=new ScrollPane(ta);

		fp.getChildren().addAll(rate,tfRate,year,
				tfYear,submit,loan,tfLoan,sp);
		fp.setHgap(10);
		Scene scene = new Scene(fp,320,250);

		submit.setOnAction(e->{
			try {
				toServer.writeDouble(Double.parseDouble(tfRate.getText()));
				toServer.flush();
				toServer.writeDouble(Double.parseDouble(tfYear.getText()));
				toServer.flush();
				toServer.writeDouble(Double.parseDouble(tfLoan.getText()));
				toServer.flush();

				ta.appendText("Annual Month Rate: "+tfRate.getText()+"\n");
				ta.appendText("Number of Years: "+tfYear.getText()+"\n");
				ta.appendText("Loan Amount: "+tfLoan.getText()+"\n");
				ta.appendText(" Month : "+fromServer.readDouble()+"\n");
				ta.appendText("total: "+fromServer.readDouble()+"\n");
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		try {
			Socket socket = new Socket("localhost", 8000);
			fromServer = new DataInputStream(socket.getInputStream());

      // Create an output stream to send data to the server
      toServer = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		primaryStage.setTitle("ShowImage"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
