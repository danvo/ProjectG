package model;

public class InvalidEntryException extends Exception {

	 public InvalidEntryException(String name) {
		 super(name + " is not a valid entry!");
	 }
}
