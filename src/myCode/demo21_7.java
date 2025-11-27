package myCode;

import java.util.*;

public class demo21_7 {
    public static void main(String[] args) {
        String text = "Good morning. Have a good class. Have a good visit. Have fun!";
        Map<String, Integer> map = new TreeMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (String word : words) {
            String key = word.toLowerCase();
            if (!key.isEmpty()) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        List<WordOccurrence> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);
        for (WordOccurrence wordOccurrence : list) {
            System.out.println(wordOccurrence.word + "\t" + wordOccurrence.count);
        }
    }
}

class WordOccurrence implements Comparable<WordOccurrence>{
    String word;
    int count;

    public WordOccurrence(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int compareTo(WordOccurrence other) {
        return this.count - other.count;
    }
}
