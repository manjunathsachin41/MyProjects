package com.examples.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLengthOfAWords {

	public static void main(String[] args) {
		//List.of = Arrays.asList but creates an immutable list.
		List<String> words = List.of("apple", "bat", "ball", "cat", "elephant", "dog", "ant");

		// In groupBy, first argument will always be key for the map
		Map<Integer,List<String>> resultMap = words.stream()
											.collect(Collectors.groupingBy(String::length));
		// 	resultMap.put(3, [bat, cat, dog, ant]);
		resultMap.forEach((length, wordList) -> System.out.println("Length: " + length + " -> Words: " + wordList));
	}

}
