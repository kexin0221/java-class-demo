package myCode;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class demo32_1 extends Application {

    private final TextField tfID = new TextField();
    private final TextField tfLastName = new TextField();
    private final TextField tfFirstName = new TextField();
    private final TextField tfMI = new TextField();
    private final TextField tfAddress = new TextField();
    private final TextField tfCity = new TextField();
    private final TextField tfState = new TextField();
    private final TextField tfTelephone = new TextField();
    private final TextField tfEmail = new TextField();
    private Connection connection;

    @Override
    public void start(Stage primaryStage) {
        connectToDB();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.add(new Label("ID"), 0, 0);
        grid.add(tfID, 1, 0);
        grid.add(new Label("Last Name"), 0, 1);
        grid.add(tfLastName, 1, 1);
        grid.add(new Label("First Name"), 0, 2);
        grid.add(tfFirstName, 1, 2);
        grid.add(new Label("MI"), 0, 3);
        grid.add(tfMI, 1, 3);
        grid.add(new Label("Address"), 0, 4);
        grid.add(tfAddress, 1, 4);
        grid.add(new Label("City"), 0, 5);
        grid.add(tfCity, 1, 5);
        grid.add(new Label("State"), 0, 6);
        grid.add(tfState, 1, 6);
        grid.add(new Label("Telephone"), 0, 7);
        grid.add(tfTelephone, 1, 7);
        grid.add(new Label("Email"), 0, 8);
        grid.add(tfEmail, 1, 8);

        Button btView = new Button("View");
        Button btInsert = new Button("Insert");
        Button btUpdate = new Button("Update");
        Button btClear = new Button("Clear");

        grid.add(btView, 0, 9);
        grid.add(btInsert, 1, 9);
        grid.add(btUpdate, 2, 9);
        grid.add(btClear, 3, 9);

        btView.setOnAction(event -> view());
        btInsert.setOnAction(event -> insert());
        btUpdate.setOnAction(event -> update());
        btClear.setOnAction(event -> clear());

        Scene scene = new Scene(grid);
        primaryStage.setTitle("Exercise32_1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clear() {
        tfID.clear();
        tfLastName.clear();
        tfFirstName.clear();
        tfMI.clear();
        tfAddress.clear();
        tfCity.clear();
        tfState.clear();
        tfTelephone.clear();
        tfEmail.clear();
    }

    private void update() {
        String sql = "UPDATE Staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, " +
                "telephone=?, email=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tfLastName.getText());
            stmt.setString(2, tfFirstName.getText());
            stmt.setString(3, tfMI.getText());
            stmt.setString(4, tfAddress.getText());
            stmt.setString(5, tfCity.getText());
            stmt.setString(6, tfState.getText());
            stmt.setString(7, tfTelephone.getText());
            stmt.setString(8, tfEmail.getText());
            stmt.setString(9, tfID.getText());
            int rows = stmt.executeUpdate();
            if (rows > 0) showAlert("Update successful");
            else showAlert("Record not found");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insert() {
        String sql = "INSERT INTOStaff VALUES (?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tfID.getText());
            stmt.setString(2, tfLastName.getText());
            stmt.setString(3, tfFirstName.getText());
            stmt.setString(4, tfMI.getText());
            stmt.setString(5, tfAddress.getText());
            stmt.setString(6, tfCity.getText());
            stmt.setString(7, tfState.getText());
            stmt.setString(8, tfTelephone.getText());
            stmt.setString(9, tfEmail.getText());
            stmt.executeUpdate();
            showAlert("Insert successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void view() {
        String sql = "SELECT * FROM Staff WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tfID.getText());
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                tfLastName.setText(resultSet.getString("lastName"));
                tfFirstName.setText(resultSet.getString("firstName"));
                tfMI.setText(resultSet.getString("mi"));
                tfAddress.setText(resultSet.getString("address"));
                tfCity.setText(resultSet.getString("city"));
                tfState.setText(resultSet.getString("state"));
                tfTelephone.setText(resultSet.getString("telephone"));
                tfEmail.setText(resultSet.getString("email"));
            } else {
                showAlert("Record not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void connectToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/education",
                    "scott", "tiger");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
