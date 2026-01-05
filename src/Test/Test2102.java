package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Test2102 {

    public static void main(String[] args) {
        File file = new File("scores.txt");
        try (Scanner input = new Scanner(file)) {
            TreeSet<String> ts = new TreeSet<>();
            while (input.hasNext()) {
                ts.add(input.next());
            }
            for (String temp : ts) {
                System.out.println(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
