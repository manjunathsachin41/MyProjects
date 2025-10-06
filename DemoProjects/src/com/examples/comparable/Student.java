package com.examples.comparable;

public class Student implements Comparable<Student> {
	
	private String name;
	
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//Sorting logic is intrinsic to the class itself.
	@Override
	public int compareTo(Student stud) {
		if (this.age > stud.age) {
			return 1;
		} else {
			return -1;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
}
