package Test;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Test2102 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        java.io.File file = new java.io.File("scores.txt");
        try (Scanner input = new Scanner(file)) {
            TreeSet<String> ts = new TreeSet<>();
            while (input.hasNext()) {
                String word = input.next();
                ts.add(word);
            }
            for (String temp : ts) System.out.println(temp);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
