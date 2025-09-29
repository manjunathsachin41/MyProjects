package com.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {

	void arrayList() {
		System.out.println("========= ArrayList Demo ===========");
		List<String> serverList = new ArrayList<>();
		serverList.add("Java");
		serverList.add("Spring Boot");
		serverList.add("Hibernate");
		serverList.add(2, "Microservices");
		serverList.add("DevOps");

		List<String> guiList = new ArrayList<>();
		guiList.addFirst("React");
		guiList.addLast("Angular Js");
		guiList.add("Java Script");

		List<String> fullList = new ArrayList<>();
		fullList.addAll(guiList);
		fullList.addAll(serverList);
		fullList.add(null);
		fullList.add(null);
		// ArrayList in Java maintains insertion order
		for (String s : fullList) {
			System.out.println(s);
		}

		boolean hasReact = fullList.contains("React");
		System.out.println("Does ArrayList contain 'React'? " + hasReact);

		System.out.println("Size of the list: " + fullList.size());

		fullList.remove("Hibernate");
		fullList.remove(0);
		System.out.println("After removing elements:");
		Iterator<String> it = fullList.iterator();
		while (it.hasNext()) {
			String subject = it.next();
			System.out.println(subject);
		}

	}

	void setDemo() {
		System.out.println("========= Set Demo ===========");
		Set<String> serverSet = new HashSet<>();
		serverSet.add("Java");
		serverSet.add("Spring Boot");
		serverSet.add("Hibernate");
		serverSet.add("Microservices");
		serverSet.add("DevOps");
		serverSet.add("Java"); // Duplicate will be ignored
		serverSet.add(null);
		serverSet.add(null); // Duplicate null, will be ignored

		for (String s : serverSet) {
			System.out.println(s);
		}
	}

	void hashMapDemo() {
		System.out.println("========= HashMap Demo ===========");
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		

		// map.keySet().forEach(key -> System.out.println("Key: " + key + ", Value: " +
		// map.get(key)));
		// Both are same
		Set<Integer> onlyKeys = map.keySet();
		for (Integer key : onlyKeys) {
			System.out.println("Key: " + key);
		}
		
		if(map.containsKey(3)) {
			map.put(3, "Three updated");
		}

		map.values().forEach(value -> System.out.println("Value: " + value));

		Set<Map.Entry<Integer, String>> entries = map.entrySet();

		// Iterate through the entry set
		for (Map.Entry<Integer, String> entry : entries) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ": " + value);
		}
	}

}
