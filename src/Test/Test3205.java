package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Test3205 extends Application{
	private Statement stmt;
	public void start(Stage primaryStage) throws Exception {
		initializeDB();
		BorderPane bp=new BorderPane();
		HBox hb=new HBox();
		hb.setSpacing(10);
		TextArea ta=new TextArea();
//		ScrollPane sp=new ScrollPane(ta);
		Label status=new Label();
		bp.setTop(hb);
//		bp.setCenter(sp);
		bp.setCenter(ta);
		bp.setBottom(status);

		Label tnameL=new Label("Table Name");
		TextField tfTname=new TextField();
		Button show=new Button("Show Contents");
		hb.getChildren().addAll(tnameL,tfTname,show);

		show.setOnAction(e->{
			ta.setText("");
			String sql="select * from "+tfTname.getText();
			try {
				ResultSet resultSet = stmt.executeQuery(sql);

                ResultSetMetaData rsMetaData = resultSet.getMetaData();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
					ta.appendText(rsMetaData.getColumnName(i)+"\t");
//		    	sb.append( rsMetaData.getColumnName(i)+"\t");
				ta.appendText("\n");

				while (resultSet.next()) {
					for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
//		      	sb.append(resultSet.getObject(i)+"\t");
						ta.appendText(resultSet.getObject(i)+"\t");
//		      	sb.append("\n");
					ta.appendText("\n");
				}
//		    ta.setText(sb.toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Scene scene = new Scene(bp,470,250);
		primaryStage.setTitle("ShowImage"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();

	}


	private void initializeDB() {
		try {
			// Load the JDBC driver
			Class.forName("org.sqlite.JDBC");
//      Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded");

			// Establish a connection
			Connection connection = DriverManager.getConnection
					("jdbc:sqlite://e:/adJava/sqllite/education.db");
//    ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
//     "scott", "tiger");
			System.out.println("Database connected");

			// Create a statement
			stmt = connection.createStatement();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
