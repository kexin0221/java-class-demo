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

		Label snoL=new Label("学号");
		TextField tfSno=new TextField();
		Button show=new Button("显示成绩");
		hb.getChildren().addAll(snoL,tfSno,show);

		show.setOnAction(e->{
	    String sno = tfSno.getText();
	    try {
	    	System.out.println(sno);
				preparedStatement.setString(1, sno);
				System.out.println(preparedStatement.toString());
				ResultSet rset = preparedStatement.executeQuery();
				StringBuffer sb=new StringBuffer();
				int count=0;
				while (rset.next()) {
	        String name = rset.getString(1);
	        String title = rset.getString(2);
	        String grade = rset.getString(3);

	        sb.append(name+" "+title+"："+grade+"\n");
	        count++;
				}
				ta.setText(sb.toString());
				status.setText(count+"门课程被查询");
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
      String queryString = "select 姓名, " +
          "课程名称, 成绩  from 学生, 选课, 课程 " +
          "where 学生.学号 = ?  " +
          "and 选课.课程号 = 课程.课程号 and 选课.学号 = 学生.学号";
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
