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
        Set<String> keywordSet = getStrings();

        try (Scanner input = new Scanner(new File("D:/code/java/Java-class-demo/src/chapter1/Welcome.java"));
             PrintWriter output = new PrintWriter("Welcome.html")) {
            output.println("<pre>");

            while (input.hasNextLine()) {
                String line = input.nextLine();
                StringBuilder htmlLine = new StringBuilder();

                boolean inComment = false;
                boolean inString = false;
                boolean inChar = false;
                StringBuilder currentWord = new StringBuilder();

                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    String token = String.valueOf(ch);

                    if (inComment) {
                        htmlLine.append(token);
                        if (ch == '\n') {
                            htmlLine.append("</span>");
                            inComment = false;
                        }
                    } else if (inString) {
                        htmlLine.append(token);
                        if (ch == '"') {
                            htmlLine.append("</span>");
                            inString = false;
                        }
                    } else if (inChar) {
                        htmlLine.append(token);
                        if (ch == '\'') {
                            htmlLine.append("</span>");
                            inChar = false;
                        }
                    } else if (ch == '"') {
                        htmlLine.append("<span style=\"color:blue\">").append(token);
                        inString = true;
                    } else if (ch == '\'') {
                        htmlLine.append("<span style=\"color:blue\">").append(token);
                        inChar = true;
                    } else if (i < line.length() - 1 && ch == '/' && line.charAt(i + 1) == '/') {
                        htmlLine.append("<span style=\"color:green\">//");
                        inComment = true;
                        i++;
                    } else if (i < line.length() - 1 && ch == '/' && line.charAt(i + 1) == '*') {
                        htmlLine.append("<span style=\"color:green\">/*");
                        inComment = true;
                        i++;
                    } else if (Character.isLetterOrDigit(ch)) {
                        currentWord.append(ch);
                    } else {
                        if (currentWord.length() > 0) {
                            String word = currentWord.toString();
                            if (keywordSet.contains(word)) {
                                htmlLine.append("<b style=\"color:darkblue\">").append(word).append("</b>");
                            } else {
                                htmlLine.append(word);
                            }
                            currentWord.setLength(0);
                        }
                        htmlLine.append(token);
                    }
                }

                if (currentWord.length() > 0) {
                    String word = currentWord.toString();
                    if (keywordSet.contains(word)) {
                        htmlLine.append("<b style=\"color:darkblue\">").append(word).append("</b>");
                    } else {
                        htmlLine.append(word);
                    }
                }

                if (inComment || inString || inChar) {
                    htmlLine.append("</span>");
                }
                output.println(htmlLine);
            }
            output.println("</pre>");
        }
    }

    private static Set<String> getStrings() {
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
                "true", "false", "null"};
        return new HashSet<>(Arrays.asList(keywords));
    }
}