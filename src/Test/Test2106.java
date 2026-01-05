package Test;

import java.util.*;

public class Test2106 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		HashMap<Integer, Integer> numCount = new HashMap<>();
		while (num != 0) {
			if (!numCount.containsKey(num)) {
				numCount.put(num, 1);
			} else {
				int value = numCount.get(num);
				value++;
				numCount.put(num, value);
			}
			num = scan.nextInt();
		}
		System.out.println(numCount);

		TreeMap<Integer,String> countNum = new TreeMap<>();
		numCount.forEach((key, value) -> {
			if(!countNum.containsKey(value)) {
				countNum.put(value, String.valueOf(key));
			} else {
				String nums = countNum.get(value);
				nums = nums + "," + key;
				countNum.put(value, nums);
			}
		});
		System.out.println(countNum);
	}
}
