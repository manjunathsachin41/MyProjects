package com.examples.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CountOccurrencesOfFruits {

	public static void main(String[] args) {
		List<String> words = List.of("apple", "bat", "apple", "elephant", "apple", "bat");
		
		Map<String,Long> resultMap = words.stream()
						.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		
		resultMap.forEach((word, count) -> System.out.println( word + " : " + count));
		
		System.out.println("===Loop using entrySet====");
		Set<Map.Entry<String,Long>> entrySet = resultMap.entrySet();
		for(Map.Entry<String,Long> entry :entrySet) {
			System.out.println("Word: " + entry.getKey() + " -> Count: " + entry.getValue());
		}

	}

}
