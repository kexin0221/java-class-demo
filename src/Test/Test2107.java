package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test2107 {
	public static void main(String[] args) {
		String text = "Good morning. Have a good class. Have a good visit. Have fun!";
		Map<String, WordOccurrence> map = new TreeMap<>();
		String[] words = text.split("[\\s+\\p{P}]");
        for (String word : words) {
            String key = word.toLowerCase();
            if (!key.isEmpty()) {
                if (!map.containsKey(key)) {
                    map.put(key, new WordOccurrence(key, 1));
                } else {
                    WordOccurrence value = map.get(key);
                    value.setCount(value.getCount() + 1);
                }
            }
        }
		map.forEach((k, v) -> System.out.println(k + "\t" + v.getCount()));

		Collection<WordOccurrence> values = map.values();
		List<WordOccurrence> temp = new ArrayList<>(values);
		Collections.sort(temp);
		System.out.println(temp);
	}
}

class WordOccurrence implements Comparable<WordOccurrence>{

	private final String word;
	private int count;

	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public int compareTo(WordOccurrence e) {
        return Integer.compare(this.getCount(), e.getCount());
	}

	public String toString() {
		return word + " " + count;
	}
}
