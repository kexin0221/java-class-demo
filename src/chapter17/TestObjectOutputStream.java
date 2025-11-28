package chapter17;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestObjectOutputStream {
    public static void main(String[] args) throws IOException {
        try ( // Create an output stream for file object.dat
              ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("object.dat")));) {
            // Write a string, double value, and object to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeObject(new java.util.Date());
        }
    }
}
