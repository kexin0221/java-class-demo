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
	private final PreparedStatement preparedStatement;

    public Test3204(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    @Override
	public void start(Stage primaryStage) throws Exception {
		initializeDB();
		BorderPane bp = new BorderPane();
		HBox hb = new HBox();
		hb.setSpacing(10);
		TextArea ta = new TextArea();
		ScrollPane sp = new ScrollPane(ta);
		Label status = new Label();
		bp.setTop(hb);
		bp.setCenter(sp);
		bp.setBottom(status);

		Label snoL = new Label("SSN");
		TextField tfSno = new TextField();
		Button show = new Button("Show Grade");
		hb.getChildren().addAll(snoL, tfSno, show);

		show.setOnAction(e -> {
			String sno = tfSno.getText();
			try {
				System.out.println(sno);
				preparedStatement.setString(1, sno);
				System.out.println(preparedStatement);
				ResultSet rset = preparedStatement.executeQuery();
				StringBuilder sb = new StringBuilder();
				int count = 0;
				while (rset.next()) {
					String name = rset.getString(1);
					String title = rset.getString(2);
					String grade = rset.getString(3);

					sb.append(name).append(" ").append(title).append(" : ").append(grade).append("\n");
					count++;
				}
				ta.setText(sb.toString());
				status.setText(count + "rows selected");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		Scene scene = new Scene(bp,470,250);
		primaryStage.setTitle("Show Grade");
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
