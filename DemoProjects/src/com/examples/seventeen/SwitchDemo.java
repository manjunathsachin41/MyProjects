package com.examples.seventeen;

public class SwitchDemo {

	public static void main(String[] args) {
		traditionalSwitch();
		lamdaSwitch();
		returnFromSwitch();
		double result = getDoubleUsingSwitch(10);
		System.out.println(result);
	}

	private static void traditionalSwitch() {
		String day = "Monday";
		switch (day) {
		case "Saturday", "Sunday":
			System.out.println("Its Weekend!!!");
			break;
		case "Monday":
			System.out.println("Its Monday!!!");
			break;
		default:
			System.out.println("Its default!!!");
			break;
		}
	}

	private static void lamdaSwitch() {
		String day = "Sunday";
		switch (day) {
			case "Saturday", "Sunday" -> System.out.println("Its Weekend!!!");
			case "Monday" -> System.out.println("Its Monday!!!");
			default -> System.out.println("Its default!!!");
		}
	}
	
	private static void returnFromSwitch() {
		String day = "Tuesday";
		String result = "";
		result = switch (day) {
			// We are returning string value here.
			case "Saturday", "Sunday" -> "Its Weekend!!!";
			case "Monday" -> "Its Monday!!!";
			case "Tuesday" -> "Its Tuesday!!!";
			default -> "Its default!!!";
		};
		System.out.println(result);
	}
	
	static double getDoubleUsingSwitch(Object o) {
		// Is Object o instance of Integer/Float.
	    return switch (o) {
	        case Integer i -> i.doubleValue();
	        case Float f -> f.doubleValue();
	        case String s -> Double.parseDouble(s);
	        default -> 0d;
	    };
	}


}
