package chapter17;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DetectEndOfFile {
    public static void main(String[] args) {
        try {
            try (DataOutputStream output =
                         new DataOutputStream(Files.newOutputStream(Paths.get("test.dat")))) {
                output.writeDouble(4.5);
                output.writeDouble(43.25);
                output.writeDouble(3.2);
            }

            try (DataInputStream input = new DataInputStream(Files.newInputStream(Paths.get("test.dat")))) {
                while (true)
                    System.out.println(input.readDouble());
            }
        }
        catch (EOFException ex) {
            System.out.println("All data were read");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
