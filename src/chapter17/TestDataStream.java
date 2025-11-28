package chapter17;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestDataStream {
    public static void main(String[] args) throws IOException {
        try ( // Create an output stream for file temp.dat
              DataOutputStream output =
                      new DataOutputStream(Files.newOutputStream(Paths.get("temp.dat")));
        ) {
            // Write student test scores to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);
        }

        try ( // Create an input stream for file temp.dat
              DataInputStream input = new DataInputStream(Files.newInputStream(Paths.get("temp.dat")));) {
            // Read student test scores from the file
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}
