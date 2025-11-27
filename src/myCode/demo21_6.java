package myCode;

import java.util.*;

public class demo21_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        while (true) {
            int num = scanner.nextInt();
            if (num == 0) break;
            map.put(num, map.getOrDefault(num, 0 ) + 1);
        }
        int maxCount = Collections.max(map.values());
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
}
