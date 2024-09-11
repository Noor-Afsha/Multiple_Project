import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingWords {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		list.add("banana");
		list.add("apple");

		Map<String, Integer> wordCounts = new HashMap<>();
		for (String word : list) {
			if (wordCounts.containsKey(word)) {
				wordCounts.put(word, wordCounts.get(word) + 1);
			} else {
				wordCounts.put(word, 1);
			}
		}

		System.out.println("Word Counts: " + wordCounts);
	}
}
