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

import java.awt.*;
import java.sql.*;

public class demo32_5 extends Application {
    private Statement stmt;
    private final TextField tfTableName = new TextField();
    private final TextArea taResult = new TextArea();
    private final Label lblStatus = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeDB();
        Button btShowContents = new Button("Show Contents");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Table Name"), tfTableName, btShowContents);

        taResult.setEditable(false);
        taResult.setPrefColumnCount(60);
        taResult.setPrefRowCount(20);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, taResult, lblStatus);
        tfTableName.setPrefColumnCount(15);
        btShowContents.setOnAction(event -> showTableContents());

        Scene scene = new Scene(vBox, 700, 500);
        primaryStage.setTitle("Exercise32_5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showTableContents() {
        String tableName = tfTableName.getText().trim();
        if (tableName.isEmpty()) {
            lblStatus.setText("Please enter table name");
            return;
        }

        try {
            String queryString = "SELECT * FROM " + tableName;
            ResultSet resultSet = stmt.executeQuery(queryString);
            ResultSetMetaData rsmd = resultSet.getMetaData();

            int columnCount = rsmd.getColumnCount();

            StringBuilder result = new StringBuilder();
            StringBuilder header = new StringBuilder();
            for (int i = 0; i < columnCount; i++) {
                header.append(String.format("%-20s", rsmd.getColumnName(i+1)));
            }
            result.append(header).append("\n");

            for (int i = 0; i < columnCount*20; i++) {
                result.append("-");
            }
            result.append("\n");

            int rowCount = 0;
            while (resultSet.next()) {
                rowCount++;
                StringBuilder row = new StringBuilder();
                for (int i = 0; i < columnCount; i++) {
                    String value = resultSet.getString(i+1);
                    if (value == null) {
                        value = "";
                    }
                    row.append(String.format("%-20s", value));
                }
                result.append(row).append("\n");
            }
            taResult.setText(result.toString());
            lblStatus.setText("Table: " + tableName + ", Rows: " + rowCount);
        } catch (SQLException e) {
            taResult.setText("");
            lblStatus.setText("Error: " + e.getMessage());
        }
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

    public static void main(String[] args) {
        launch(args);
    }
}
