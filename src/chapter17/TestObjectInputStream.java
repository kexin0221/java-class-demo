package chapter17;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestObjectInputStream {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("object.dat")));) {
            // Read a string, double value, and object from the file
            String name = input.readUTF();
            double score = input.readDouble();
            java.util.Date date = (java.util.Date)(input.readObject());
            System.out.println(name + " " + score + " " + date);
        }
    }
}
