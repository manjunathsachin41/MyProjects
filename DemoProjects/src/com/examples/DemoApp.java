package com.examples;

public class DemoApp {

	public static void main(String args[]) {

		StringDemo st = new StringDemo();
		st.stackHeapMemory();
		st.compareString();
		st.demoStringBuilder();
		st.stringRegularExpression();
		st.reverseString();
		
		CollectionsDemo cd = new CollectionsDemo();
		cd.arrayList();
		cd.setDemo();
		cd.hashMapDemo();
		
	}
}
