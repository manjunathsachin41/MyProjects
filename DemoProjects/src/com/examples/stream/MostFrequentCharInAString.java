package com.examples.stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MostFrequentCharInAString {

	public static void main(String[] args) {
		String input = "banana";
		
		IntStream intStream = input.chars();
		intStream.forEach(ch -> System.out.print(ch+" "));
		
		System.out.println();
		
		Map<Character,Long> collect = input.chars()
									.mapToObj(c -> (char)c) //convert from int to char stream
									.collect(Collectors.groupingBy(c -> c,
											Collectors.counting()));
		collect.forEach((ch,count) -> System.out.println(ch+" : "+count));
		
		Map.Entry<Character, Long> entry= collect.entrySet().stream()
											.max(Map.Entry.comparingByValue())
											.orElseThrow();
		System.out.println("Maximum Char: "+entry.getKey()+" : "+entry.getValue());
	}

}
