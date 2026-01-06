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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Test3205 extends Application{
	private Statement stmt;
	public void start(Stage primaryStage) throws Exception {
		initializeDB();
		BorderPane bp = new BorderPane();
		HBox hb = new HBox();
		hb.setSpacing(10);
		TextArea ta = new TextArea();
		Label status = new Label();
		bp.setTop(hb);
		bp.setCenter(ta);
		bp.setBottom(status);

		Label tnameL = new Label("Table Name");
		TextField tfTname = new TextField();
		Button show = new Button("Show Contents");
		hb.getChildren().addAll(tnameL,tfTname,show);

		show.setOnAction(e -> {
			ta.setText("");
			String sql="select * from " + tfTname.getText();
			try {
				ResultSet resultSet = stmt.executeQuery(sql);
                ResultSetMetaData rsMetaData = resultSet.getMetaData();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					ta.appendText(rsMetaData.getColumnName(i) + "\t");
				}
				ta.appendText("\n");
				while (resultSet.next()) {
					for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
						ta.appendText(resultSet.getObject(i) + "\t");
					}
					ta.appendText("\n");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		Scene scene = new Scene(bp,470,250);
		primaryStage.setTitle("ShowImage");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void initializeDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Driver loaded");
			Connection connection = DriverManager.getConnection
					("jdbc:sqlite://D:\\code\\java\\Java-class-demo\\education.db");
			System.out.println("Database connected");
			stmt = connection.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
