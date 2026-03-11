package com.exception;

public class Validator {
 
public static void validateAge ( int age ) throws InvalidAgeException {

	if ( age < 18 ) {
		throw new InvalidAgeException("age muct be 18 or above ");
	}
	System.out.println(" invalid age ");
}
}
