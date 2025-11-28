package chapter18;

import java.io.File;
import java.util.Scanner;

public class DirectorySize {
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        // Display the size
        System.out.println(getSize(new File(directory)) + " bytes");
    }

    public static long getSize(File file) {
        long size = 0; // Store the total size of all files

        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            assert files != null;
            for (File value : files) {
                size += getSize(value); // Recursive call
            }
        }
        else { // Base case
            size += file.length();
        }

        return size;
    }
}
