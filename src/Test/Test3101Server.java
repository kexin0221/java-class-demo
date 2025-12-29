package Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Test3101Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("Server started ");
			while (true) {
				// Listen for a new connection request
				Socket socket = serverSocket.accept();

				new Thread (()->{
					while(true)
					{
						try {
							DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
							DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
							double rate = inputFromClient.readDouble();
							double year = inputFromClient.readDouble();
							double loan = inputFromClient.readDouble();
							System.out.println(rate+" "+year+" "+loan);

							double total=loan*Math.pow(1+rate, year);
							double month=total/(year*12);
							outputToClient.writeDouble(month);
							outputToClient.writeDouble(total);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}).start();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
