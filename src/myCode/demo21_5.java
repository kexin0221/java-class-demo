package myCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class demo21_5 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
                "true", "false", "null"};
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));

        try (Scanner input = new Scanner(new File(args[0]));
             PrintWriter output = new PrintWriter(args[1])) {
            output.println("<pre>");

            while (input.hasNextLine()) {
                String line = input.nextLine();
                StringBuilder htmlLine = new StringBuilder();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("");

                boolean inCommon = false;
                boolean isString = false;
                boolean inChar = false;

                while (lineScanner.hasNext()) {
                    String token = lineScanner.next();

                }
            }
        }
    }
}
