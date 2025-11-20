package myCode;

import java.io.File;
import java.util.*;

public class demo21_2 {
    public static void main(String[] args) throws Exception {
        Set<String> set = new TreeSet<>();
        Scanner scanner = new Scanner(new File("D:/code/java/Java-class-demo/src/myCode/words.txt"));
        while (scanner.hasNext()) {
            set.add(scanner.next().toLowerCase());
        }
        for (String word : set) {
            System.out.println(word);
        }
    }
}