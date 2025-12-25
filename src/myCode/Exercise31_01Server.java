package myCode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise31_01Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server start");

            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream fromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());

                double annualInterestRate = fromClient.readDouble();
                int numOfYears = fromClient.readInt();
                double loanAmount = fromClient.readDouble();

                double monthlyInterestRate = annualInterestRate / 1200;
                double monthlyPayment = loanAmount * monthlyInterestRate /
                        (1 - 1 / Math.pow(1 + monthlyInterestRate, numOfYears * 12));
                double totalPayment = monthlyPayment * numOfYears * 12;

                toClient.writeDouble(monthlyPayment);
                toClient.writeDouble(totalPayment);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
