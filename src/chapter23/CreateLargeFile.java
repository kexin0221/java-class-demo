package chapter23;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateLargeFile {
    public static void main(String[] args) throws Exception {
        DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(Paths.get("largedata.dat"))));

        for (int i = 0; i < 800004; i++)
            output.writeInt((int)(Math.random() * 1000000));

        output.close();

        // Display first 100 numbers
        DataInputStream input = new DataInputStream(Files.newInputStream(Paths.get("largedata.dat")));
        for (int i = 0; i < 100; i++)
            System.out.print(input.readInt() + " ");

        input.close();
    }
}
