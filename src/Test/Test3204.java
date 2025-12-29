package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class Test3204 extends Application {
	private PreparedStatement preparedStatement;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initializeDB();
		BorderPane bp=new BorderPane();
		HBox hb=new HBox();
		hb.setSpacing(10);
		TextArea ta=new TextArea();
		ScrollPane sp=new ScrollPane(ta);
		Label status=new Label();
		bp.setTop(hb);
		bp.setCenter(sp);
		bp.setBottom(status);

		Label snoL=new Label("???");
		TextField tfSno=new TextField();
		Button show=new Button("??????");
		hb.getChildren().addAll(snoL,tfSno,show);

		show.setOnAction(e->{
			String sno = tfSno.getText();
			try {
				System.out.println(sno);
				preparedStatement.setString(1, sno);
				System.out.println(preparedStatement.toString());
				ResultSet rset = preparedStatement.executeQuery();
				StringBuilder sb=new StringBuilder();
				int count=0;
				while (rset.next()) {
					String name = rset.getString(1);
					String title = rset.getString(2);
					String grade = rset.getString(3);

					sb.append(name).append(" ").append(title).append("??").append(grade).append("\n");
					count++;
				}
				ta.setText(sb.toString());
				status.setText(count+"????????");
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
					("jdbc:sqlite://f:/adJava/sqllite/education.db");
//    ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
//     "scott", "tiger");
			System.out.println("Database connected");
			String queryString = "select ????, " +
					"???????, ???  from ???, ???, ??? " +
					"where ???.??? = ?  " +
					"and ???.???? = ???.???? and ???.??? = ???.???";
			// Create a statement
			preparedStatement = connection.prepareStatement(queryString);
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
