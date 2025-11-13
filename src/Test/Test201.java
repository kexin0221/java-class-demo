package Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test201 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		java.io.File file = new java.io.File("scores.txt");
        if (args.length != 1) {
            System.out.println("�÷�: java Test201 �ļ���");
            System.exit(1);
        }

        String fileName = args[0];
        java.io.File file = new java.io.File(fileName);
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> allWords = new ArrayList<String>();
        // Create a Scanner for the file
        try (Scanner input = new Scanner(file)) {

            // Read data from a file
            while (input.hasNext()) {
                // System.out.println(input.next());
                String temp = input.next();
                allWords.add(temp);
                char t = temp.charAt(0);
                if (t >= 'a' && t <= 'z' || t >= 'A' && t <= 'Z')
                    words.add(temp);
            }
            System.out.println(allWords);
            System.out.println(words);
            Collections.sort(words);
            System.out.println(words);
            words.sort(Collections.reverseOrder());
            System.out.println(words);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
