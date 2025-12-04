package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test2107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String text = "Good morning. Have a good class. " +
		      "Have a good visit. Have fun!";

		    // Create a TreeMap to hold words as key and count as value
		    Map<String, WordOccurrence> map = new TreeMap<>();

		    String[] words = text.split("[\\s+\\p{P}]");
		    for (int i = 0; i < words.length; i++) {
		      String key = words[i].toLowerCase();

		      if (key.length() > 0) {
		        if (!map.containsKey(key)) {
		          map.put(key, new WordOccurrence(key,1));
		        }
		        else {
		        	WordOccurrence value = map.get(key);
		        	value.setCount(value.getCount()+1);
		        }
		      }
		    }

		    // Display key and value for each entry
		    map.forEach((k, v) -> System.out.println(k + "\t" + v.getCount()));

		    Collection<WordOccurrence> values=map.values();
		    List<WordOccurrence> temp=new ArrayList<>(values);
		    Collections.sort(temp);
		    System.out.println(temp);
	}

}

class WordOccurrence implements Comparable<WordOccurrence>{

	private String word;
	private int count;

	public WordOccurrence(String word, int count)
	{
		this.word=word;
		this.count=count;
	}

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public int compareTo(WordOccurrence e)
	{
		if(this.getCount()<e.getCount())
		{
			return -1;
		}
		else if(this.getCount()==e.getCount())
		{
			return 0;
		}
		else
		{
			return 1;
		}
  }

	public String toString()
	{
		return word+" "+count;
	}
}
