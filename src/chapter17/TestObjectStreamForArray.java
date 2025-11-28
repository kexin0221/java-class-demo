package chapter17;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestObjectStreamForArray {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"John", "Susan", "Kim"};

        try ( // Create an output stream for file array.dat
              ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat", true));) {
            // Write arrays to the object output stream
            output.writeObject(numbers);
            output.writeObject(strings);
        }

        try ( // Create an input stream for file array.dat
              ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("array.dat")))) {
            int[] newNumbers = (int[])(input.readObject());
            String[] newStrings = (String[])(input.readObject());

            // Display arrays
            for (int newNumber : newNumbers) System.out.print(newNumber + " ");
            System.out.println();

            for (String newString : newStrings) System.out.print(newString + " ");
        }
    }
}
