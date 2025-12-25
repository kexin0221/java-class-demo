package myCode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class demo32_4 extends Application {
    private Statement stmt;
    private final TextField tfSSN = new TextField();
    private final TextArea taResult = new TextArea();
    private final Label lblStatus = new Label();

    @Override
    public void start(Stage primaryStage) {
        initializeDB();

        Button btShowGrade = new Button("Show Grade");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("学号"), tfSSN, btShowGrade);

        taResult.setEditable(false);
        taResult.setPrefRowCount(15);
        taResult.setPrefColumnCount(40);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, taResult, lblStatus);

        tfSSN.setPrefColumnCount(6);
        btShowGrade.setOnAction(e -> showGrade());

        Scene scene = new Scene(vBox, 420, 300);
        primaryStage.setTitle("FindGrade");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\code\\java\\Java-class-demo\\src\\myCode\\education.db");
            System.out.println("Database connected");
            stmt = connection.createStatement();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showGrade() {
        String ssn = tfSSN.getText();
        if (ssn.isEmpty()) {
            lblStatus.setText("Please enter SSN");
            return;
        }
        try {
            String queryString = "select 学生.姓名, 课程.课程名称, 选课.成绩 " +
                    "from 学生, 选课, 课程 " +
                    "where 学生.学号 = '" + ssn +
                    "' and 选课.课程号 = 课程.课程号 " +
                    "and 选课.学号 = 学生.学号 " +
                    "order by 课程.课程名称";

            ResultSet rset = stmt.executeQuery(queryString);

            StringBuilder result = new StringBuilder();
            boolean found = false;
            int count = 0;
            String studentName = "";

            while (rset.next()) {
                found = true;
                count++;

                if (count == 1) {
                    studentName = rset.getString(1);
                }

                String courseName = rset.getString(2);
                String grade = rset.getString(3);

                result.append(studentName).append("在").append(courseName).append("课程中的成绩为").
                        append(grade).append("\n");
            }
            if (found) {
                taResult.setText(String.valueOf(result));
                lblStatus.setText("共找到 " + count + " 门课程成绩");
            } else {
                taResult.setText("");
                lblStatus.setText("未找到学号为 " + ssn + " 的成绩记录");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

