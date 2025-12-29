package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test3201 extends Application {
	private Statement stmt;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initializeDB();
		BorderPane bp=new BorderPane();
		VBox vb=new VBox();
		vb.setSpacing(10);
		HBox hb=new HBox();
		hb.setAlignment(Pos.TOP_CENTER);
		hb.setSpacing(10);
		hb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		Label status=new Label();
		bp.setTop(status);
		bp.setCenter(vb);
		bp.setBottom(hb);

		FlowPane fp1=new FlowPane();
		fp1.setHgap(5);
		Label idL=new Label("id");
		TextField tfID=new TextField();
		fp1.getChildren().addAll(idL,tfID);
		vb.getChildren().add(fp1);

		Label ln=new Label("Last Name");
		TextField tfLN=new TextField();
		Label fn=new Label("first Name");
		TextField tfFN=new TextField();
		Label mi=new Label("MI");
		TextField tfMI=new TextField();
		tfMI.setMaxWidth(25);
		FlowPane fp2=new FlowPane();
		fp2.setHgap(5);
		fp2.getChildren().addAll(ln,tfLN,
				fn,tfFN,mi,tfMI);
		vb.getChildren().add(fp2);

		FlowPane fp3=new FlowPane();
		fp3.setHgap(5);
		Label addL=new Label("Adress");
		TextField tfADD=new TextField();
		fp3.getChildren().addAll(addL,tfADD);
		vb.getChildren().add(fp3);

		Label city=new Label("City");
		TextField tfCity=new TextField();
		Label state=new Label("State");
		TextField tfSta=new TextField();
		FlowPane fp4=new FlowPane();
		fp4.setHgap(5);
		fp4.getChildren().addAll(city,tfCity,
				state,tfSta);
		vb.getChildren().add(fp4);

		FlowPane fp5=new FlowPane();
		fp5.setHgap(5);
		Label telL=new Label("Telephone");
		TextField tfTel=new TextField();
		Label emailL=new Label("email");
		TextField tfEmail=new TextField();
		fp5.getChildren().addAll(telL,tfTel
				,emailL,tfEmail);
		vb.getChildren().add(fp5);

		Button view=new Button("view");
		Button insert=new Button("insert");
		Button update=new Button("update");
		Button clear=new Button("clear");
		hb.getChildren().addAll(view,insert,update,clear);

		view.setOnAction(e->{
			String sql= "select * from staff where id='"
					+tfID.getText()+"'";
			try {
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					tfLN.setText(rs.getString("lastName"));
					tfFN.setText(rs.getString("firstName"));
					tfMI.setText(rs.getString("mi"));
					tfADD.setText(rs.getString("address"));
					tfCity.setText(rs.getString("city"));
					tfSta.setText(rs.getString("state"));
					tfTel.setText(rs.getString("telephone"));
					tfEmail.setText(rs.getString("email"));
					status.setText("SUCC");
				}
				else
				{
					status.setText("NO DATA");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		insert.setOnAction(e->{
			String sql="insert into staff values('"+
					tfID.getText()+"','"+
					tfLN.getText()+"','"+
					tfFN.getText()+"','"+
					tfMI.getText()+"','"+
					tfADD.getText()+"','"+
					tfCity.getText()+"','"+
					tfSta.getText()+"','"+
					tfTel.getText()+"','"+
					tfEmail.getText()+"')";
			try {
				System.out.println(sql);
				int rows=stmt.executeUpdate(sql);
				status.setText(rows+" rows update");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		update.setOnAction(e->{
			String sql="update staff set lastName='"
					+tfLN.getText()+"',firstName='"
					+tfFN.getText()+"',mi='"
					+tfMI.getText()+"',address='"
					+tfADD.getText()+"',city='"
					+tfCity.getText()+"',state='"
					+tfSta.getText()+"',telephone='"
					+tfTel.getText()+"',email='"
					+tfEmail.getText()+"' where id='"
					+tfID.getText()+"'";

			try {
				System.out.println(sql);
				int rows=stmt.executeUpdate(sql);
				status.setText(rows+" rows update");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		clear.setOnAction(e->{
			tfID.setText("");
			tfLN.setText("");
			tfFN.setText("");
			tfMI.setText("");
			tfADD.setText("");
			tfCity.setText("");
			tfSta.setText("");
			tfTel.setText("");
			tfEmail.setText("");

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

      // Create a statement
      stmt = connection.createStatement();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
	public static void main(String[] args) {
    launch(args);
  }


}
