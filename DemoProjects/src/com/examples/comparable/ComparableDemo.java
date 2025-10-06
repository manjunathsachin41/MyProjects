package com.examples.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

	public void demoOne() {
		Student s1 = new Student("Alice", 22);
		Student s2 = new Student("Bob", 25);

		// Directly calling compareTo method
		int comparisonResult = s1.compareTo(s2);

		if (comparisonResult < 0) {
			System.out.println(s1.getName() + " is younger than " + s2.getName());
		} else if (comparisonResult > 0) {
			System.out.println(s1.getName() + " is older than " + s2.getName());
		} else {
			System.out.println(s1.getName() + " is the same age as " + s2.getName());
		}
	}

	public void demoTwo() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Naveen", 22));
		studentList.add(new Student("John", 12));
		studentList.add(new Student("Kiran", 28));
		studentList.add(new Student("Deepika", 20));

		// This sort will use the compareTo method of Student class
		Collections.sort(studentList);

		for (Student stud : studentList) {
			System.out.println(stud.getName() + " : " + stud.getAge());
		}

	}

}
