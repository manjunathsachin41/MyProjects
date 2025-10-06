package com.examples.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public void demoOne() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Alice", 22));
		personList.add(new Person("Bob", 25));
		personList.add(new Person("Charlie", 20));

		// Using Comparator to sort by age
		// Compare method is outside of Person class
		Comparator<Person> comparator = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return Integer.compare(p1.getAge(), p2.getAge());
			}
		};

		// This sort will use the compare method of the Comparator
		personList.sort(comparator);

		for (Person person : personList) {
			System.out.println(person.getName() + " : " + person.getAge());
		}

	}

	public void demoTwo() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Katrina", 22));
		personList.add(new Person("Deepika", 25));
		personList.add(new Person("Charlie", 20));

		// Using Comparator to sort by age
		Comparator<Person> comparator = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return Integer.compare(p1.getAge(), p2.getAge());
			}
		};
		
	// Using Lambda expression to create Comparator as its functional interface
	//	Comparator<Person> lamdaComparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());

		// This sort will use the compare method of the Comparator
		Collections.sort(personList, comparator);

		for (Person person : personList) {
			System.out.println(person.getName() + " : " + person.getAge());
		}
	}

}
