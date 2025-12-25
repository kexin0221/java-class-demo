package myCode;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exercise31_01Client extends Application {
    private final TextField tfAnnualInterestRate = new TextField();
    private final TextField tfNumOfYears = new TextField();
    private final TextField tfLoanAmount = new TextField();
    private final TextArea taResult = new TextArea();
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new Label("Annual Interest Rate"), 0, 0);
        gridPane.add(tfAnnualInterestRate, 1, 0);
        gridPane.add(new Label("Number of Years"), 0, 1);
        gridPane.add(tfNumOfYears, 1, 1);
        gridPane.add(new Label("Loan Amount"), 0, 2);
        gridPane.add(tfLoanAmount, 1, 2);

        Button btSubmit = new Button("Submit");
        gridPane.add(btSubmit, 1, 3);

        taResult.setPrefRowCount(10);
        gridPane.add(new Label("Result"), 0, 4);
        gridPane.add(taResult, 0, 5, 2, 1);

        btSubmit.setOnAction(event -> connectToServer());
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Exercise31_01CLient");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 8000);
            DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
            DataInputStream fromServer = new DataInputStream(socket.getInputStream());
            double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText());
            int numOfYears = Integer.parseInt(tfNumOfYears.getText());
            double loanAmount = Double.parseDouble(tfLoanAmount.getText());
            toServer.writeDouble(annualInterestRate);
            toServer.writeInt(numOfYears);
            toServer.writeDouble(loanAmount);
            toServer.flush();

            double monthlyPayment = fromServer.readDouble();
            double totalPayment = fromServer.readDouble();;

            taResult.setText("Annual Interest Rate: " + annualInterestRate + "\n" +
                    "Number of Years: " + numOfYears + "\n" +
                    "Loan Amount: " + loanAmount + "\n" +
                    "MonthlyPayment: " + monthlyPayment + "\n" +
                    "TotalPayment: " + totalPayment);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
