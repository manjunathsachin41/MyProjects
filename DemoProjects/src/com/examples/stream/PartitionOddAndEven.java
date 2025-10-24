package com.examples.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionOddAndEven {

	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

		Map<Boolean, List<Integer>> map = list.stream()
							.collect(Collectors.partitioningBy(num -> num % 2 == 0));
		
		/*Partitioning is done based on the predicate provided,
		 * if the condition is true, the element goes to the 'true' partition,
		 * else it goes to the 'false' partition.
		*/
		System.out.println(map);

	}

}
