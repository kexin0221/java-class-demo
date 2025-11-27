package chapter12;

import java.io.PrintWriter;

public class FinallyDemo {
    public static void main(String[] args) {

        try (PrintWriter output = new java.io.PrintWriter("text.txt")) {
            // Create a file

            // Write formatted output to the file
            output.println("Welcome to Java");
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
        // Close the file

        System.out.println("End of the program");
    }
}
