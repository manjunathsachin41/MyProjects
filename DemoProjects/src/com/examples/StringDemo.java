package com.examples;

import java.util.Arrays;
import java.util.List;

public class StringDemo {

	void compareString() {
		String str1 = "Java";
		String str2 = "Java";
		if (str1 == str2) {
			System.out.println("Both are same");
		} else {
			System.out.println("Both are different");
		}
	}

	@SuppressWarnings("unused")
	void stackHeapMemory() {
		// Stores str1 in stack memory
		String str1 = "Sachin";
		str1 = "Tendulkar";
		System.out.println("String is " + str1.length());

		// Stores str2 in heap memory coz new keyword is used.
		String str2 = new String("ABC");

		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("Geeks");
		strBuffer.append("for");
		strBuffer.append("All");
		String message = strBuffer.toString();
		System.out.println(message);
	}

	void demoStringBuilder() {
		System.out.println("======String Builder Demo============");
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println("Initial StringBuilder: " + sb);
		//capacity = 16 + length of string
		System.out.println("Number of chars in StringBuilder: "+sb.capacity());

		// 2. Appending to StringBuilder
		sb.append(" World!");
		System.out.println("After append: " + sb);

		// 3. Inserting into StringBuilder
		sb.insert(6, "Java "); // Inserts "Java " at index 6
		System.out.println("After insert: " + sb);

		// 4. Replacing a portion of StringBuilder
		sb.replace(0, 5, "Hi"); // Replaces "Hello" with "Hi"
		System.out.println("After replace: " + sb);

		// 5. Deleting from StringBuilder
		sb.delete(3, 8); // Deletes "Java " (from index 3 to 7)
		System.out.println("After delete: " + sb);

		// 6. Reversing StringBuilder
		sb.reverse();
		System.out.println("After reverse: " + sb);

		// Default Capacity: When a StringBuilder is created using the no-argument
		// constructor (new StringBuilder()), it is initialized with a default capacity
		// of 16 characters. Once it exceeds this capacity, it automatically increases its size.
		// new size = 2* old size
		System.out.println("Number of chars in StringBuilder: "+sb.capacity());

		// 7. Converting StringBuilder to String
		String finalString = sb.toString();
		System.out.println("Final String: " + finalString);
	}
	
	void stringRegularExpression() {
		
		System.out.println("======String RegularExps Demo============");
		
		String s = "This is,comma.fullstop  whitespace";

		// The regex [,\\s\\.] splits the string by
		// commas (,), spaces (\\s), and periods (\\.)
		String regex = "[,\\s\\.]";

		// using split() method
		String[] arr = s.split(regex);
		List<String> list=Arrays.asList(arr);
		
		// Print each element of the resulting array
		list.forEach(System.out::println);
	}
	
	void reverseString() {
		
		System.out.println("======Reverse String Demo============");
		String original = "This is,comma.fullstop  whitespace";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }
        System.out.println("Reversed String: " + reversed);
	}

}
