package Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
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
		// TODO Auto-generated method stub
		Set<String> keywordSet =
	      new HashSet<>(Arrays.asList(keywordString));

		java.io.File file = new java.io.File("./src/chapter1/ShowLogicErrors.java");
		Scanner input = null;
		try {
			input = new Scanner(file);

			StringBuffer sb=new StringBuffer("<html><body>");
			// Read data from a file
			int count=0;
			while (input.hasNext()) {
				// System.out.println(input.next());
				String temp = input.nextLine().trim();
				if(temp.indexOf("//")==0)sb.append("<p style=\"color:green\">"+temp+"</p>\n");
				else
				{
					String[] temps=temp.split(" ");
//				System.out.println(temp);
					for(String t1:temps)
					{
						if(keywordSet.contains(t1))
						{
							sb.append(" <font color=DarkBlue>"+t1+"</font> ");
						}
						else if(t1.indexOf("\"")>0)
						{
							String[] lits=t1.split("\"");
							sb.append(lits[0]);
							for(int i=1;i<lits.length;i++)
							{
								if(count%2==0)
								{
									sb.append("<font color=blue>\""+lits[i]);
									count++;
								}
								else
								{
									sb.append("\"</font>"+lits[i]);
									count++;
								}
							}
						}
						else if(t1.indexOf("\"")==0)
						{
							if(count%2==0)
							{
								sb.append("<font color=blue>"+t1);
								count++;
							}
							else
							{
								sb.append("</font>"+t1);
								count++;
							}
						}
						else
						{
							sb.append(" "+t1+" ");
						}
					}
					sb.append("<p></p>");
				}
			}
			sb.append("</body></html>");
			System.out.print(sb);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
		}
	}

}
