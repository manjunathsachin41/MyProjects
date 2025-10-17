package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.search.SearchTechnique;

public class ExampleApp {

	public static void main(String[] args) {
		reverseString();
		removeStarAndLeftOfStar();
		insertStringAtGivenIndex();
		removeRepeatationsInString();
		findRepetationsAndItsCount();
		swapWordsInAStrings();
		
		searchOperations();
	}

	private static void searchOperations() {
		SearchTechnique st = new SearchTechnique();
		st.doLinearSearch();
		st.binarySearch();
		
	}

	private static void reverseString() {
		String inputString = "Computer Coding";
		int length = inputString.length();
		String outputString = new String();
		for (int i = length - 1; i >= 0; i--) {
			outputString = outputString + inputString.charAt(i);
		}

		System.out.println("Reverse string is: " + outputString);
	}

	private static void removeStarAndLeftOfStar() {
		String inputString = "leet**cod*e";
		// String inputString = "erase*****";
		StringBuilder inputStb = new StringBuilder(inputString);
		StringBuilder outStb = new StringBuilder();
		int length = inputStb.length();

		for (int i = 0; i < length; i++) {
			char currentLetter = inputStb.charAt(i);
			outStb.append(currentLetter);
			if (currentLetter == '*') {
				int outLenght = outStb.length();
				outStb.deleteCharAt(outLenght - 1);
				outStb.deleteCharAt(outLenght - 2);
			}
		}
		System.out.println(outStb);

	}

	private static void insertStringAtGivenIndex() {
		String inputString = "GeeksGeeks";
		String toBeInserted = "For";
		int index = 4;
		int length = inputString.length();
		String outputString = "";

		for (int i = 0; i < length; i++) {
			char currentChar = inputString.charAt(i);
			outputString = outputString + currentChar;
			if (i == index) {
				outputString = outputString + toBeInserted;
			}
		}
		System.out.println(outputString);

	}

	private static void findRepetationsAndItsCount() {
		String inputString = "Dexter Marggan";
		int length = inputString.length();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			char currentChar = inputString.charAt(i);
			if (map.containsKey(currentChar)) {
				int count = map.get(currentChar);
				map.put(currentChar, count + 1);
			} else {
				map.put(currentChar, 1);
			}
		}

		Set<Map.Entry<Character, Integer>> entries = map.entrySet();

		// Iterate through the entry set
		for (Map.Entry<Character, Integer> entry : entries) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + ": " + value);
		}
	}

	// Remove Repeat = Use Set
	private static void removeRepeatationsInString() {
		String inputString = "Programming";
		Set<Character> charSet = new HashSet<>();
		int lenght = inputString.length();
		String outputString = "";

		for (int i = 0; i < lenght; i++) {
			char currentChar = inputString.charAt(i);
			if (charSet.add(currentChar)) {
				outputString = outputString + currentChar;
			}
		}

		System.out.println(outputString);

	}

	private static void swapWordsInAStrings() {
		 String inputString = "the sky is blue";
		//String inputString = "a good   example";
		// Replace more consecutive spaces with single space
		String reducedString = inputString.replaceAll("\\s+", " ");
		String[] words = reducedString.split(" ");
		int frontIndex = 0;
		int rearIndex = words.length - 1;
		String temp;
		while (frontIndex < rearIndex) {
			temp = words[frontIndex];
			words[frontIndex] = words[rearIndex];
			words[rearIndex] = temp;
			frontIndex++;
			rearIndex--;
		}

		for (String word : words) {
			System.out.print(word + " ");
		}
		System.out.println();
	}

}
