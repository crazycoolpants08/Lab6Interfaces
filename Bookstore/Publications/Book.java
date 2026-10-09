// Student Name: Heidi Faustermann
// LSU ID: 891648160
// Assignment: Lab 6 Interfaces

package Bookstore.Publications;

import Bookstore.Interfaces.Citable;

public class Book extends Publication implements Citable{
	private String author;
	private String publisher;
	private int publicationYear;

	public Book(String t, String g, String a, String p, int pY){
		super(t, g);
		author = a;
		publisher = p;
		publicationYear = pY;
	}

	@Override
	public void printInfo() {
		System.out.printf("%s by %s was published by %s in %d :: %s%n", title, author, publisher, publicationYear, genre);
	}

	// TODO - Implement the MLA Citation from the Citable interface
	@Override
	public void MLACitation() {
		//Finds the last space in the authors name
		int lastSpace = author.lastIndexOf(" ");
		String formattedName = author;
		
		//Makes the firstName from the beginning until the space in the name
		String firstName = author.substring(0, lastSpace);
		//Makes the lastName from the first letter after the space until the end
		String lastName = author.substring(lastSpace + 1);
		
		//Checks for single author groups like The Culinary Institute of America
		//Prevents it from being formatted lastName, firstName
		if (!author.contains(",") && author.contains(" ") && author.startsWith("The")) {
			formattedName = author;
		} else {
			//formats the name to be lastName, firstName
			formattedName = lastName + ", " + firstName;
		}
		
		
		//Checks if the last character if a period so Fuller, Lon L. doesn't have an extra period
		//Fuller, Lon L. prints instead of Fuller, Lon L..
		if (formattedName.charAt(formattedName.length() - 1) == '.') {
			formattedName = formattedName.substring(0, formattedName.length() - 1);
		}

		System.out.printf("%s. %s. %s, %d.%n", formattedName, title, publisher, publicationYear);
	}
	
}
