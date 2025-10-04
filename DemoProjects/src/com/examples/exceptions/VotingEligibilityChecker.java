package com.examples.exceptions;

public class VotingEligibilityChecker {

	public void checkVotingEligibility(String name, int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException(name + " is not eligible to vote");
		} else {
			System.out.println(name + " is eligible to vote");
		}
	}

	public void checkNameInVoterList(String name) throws NameNotFoundException {
		// Simulating a voter list
		String[] voterList = { "Alice", "Bob", "Charlie", "David" };
		boolean isFound = false;
		for (String voter : voterList) {
			if (voter.equalsIgnoreCase(name)) {
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			throw new NameNotFoundException(name + " not found in the voter list");
		} else {
			System.out.println(name + " found in the voter list");
		}
	}

}
