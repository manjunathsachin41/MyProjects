package com.example.search;

public class SearchTechnique {

	public void doLinearSearch() {
		int[] input = { 93, 15, 36, 76, 84 };
		int targetValue = 36;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == targetValue) {
				System.out.println("Linear Search Value found at index: " + i);
				break;
			}
		}
	}

	public void binarySearch() {
		int[] input = { 15, 36, 76, 84, 93, 100 };
		int targetValue = 84;
		int start = 0;
		int end = input.length - 1;

		while (start <= end) {
			int mid = start + (start) / 2;
			if (input[mid] == targetValue) {
				System.out.println("Binary Search Value found at index: " + mid);
				break;
			} else if (input[mid] < targetValue) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

	}

}
