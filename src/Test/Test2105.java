package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test2105 {
    static String[] keywordString = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

    public static void main(String[] args) {
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        File file = new File("./src/chapter1/ShowLogicErrors.java");

        try (Scanner input = new Scanner(file)) {
            StringBuffer sb = new StringBuffer("<html><body>");
            int count = 0;
            while (input.hasNext()) {
                String temp = input.nextLine().trim();
                if (temp.indexOf("//") == 0) {  // 注释行
                    sb.append("<p style=\"color:green\">").append(temp).append("</p>\n");
                } else {
                    String[] temps = temp.split(" ");
                    for (String t1 : temps) {
                        if (keywordSet.contains(t1)) {  // 关键字
                            sb.append(" <font color=DarkBlue>").append(t1).append("</font> ");
                        } else if (t1.indexOf("\"") > 0) {
                            String[] lits = t1.split("\"");
                            sb.append(lits[0]);
                            for (int i = 1; i < lits.length; i++) {
                                if (count % 2 == 0) {
                                    sb.append("<font color=blue>\"").append(lits[i]);
                                } else {
                                    sb.append("\"</font>").append(lits[i]);
                                }
                                count++;
                            }
                        } else if (t1.indexOf("\"") == 0) {
                            if (count % 2 == 0) {
                                sb.append("<font color=blue>").append(t1);
                            } else {
                                sb.append("</font>").append(t1);
                            }
                            count++;
                        } else {
                            sb.append(" ").append(t1).append(" ");
                        }
                    }
                    sb.append("<p></p>");
                }
            }
            sb.append("</body></html>");
            System.out.print(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
