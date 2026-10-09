// Student Name: Heidi Faustermann
// LSU ID: 891648160
// Assignment: Lab 6 Interfaces

package Bookstore.Publications;

import Bookstore.Interfaces.Citable;

public class Research extends Publication implements Citable{
	private String[] authors;
	private String journal;
	private int publicationYear;

	public Research(String t, String g, String[] a, String j, int pY){
		super(t, g);
		authors = a;
		journal = j;
		publicationYear = pY;
	}

	@Override
	public void printInfo() {
		String authorString = authors[0];
		if(authors.length > 1){
			authorString += " et al";
		}

		System.out.printf("%s by %s was published in %s in %d :: %s%n", title, authorString, journal, publicationYear, genre);
	}

	// TODO - Implement the MLA Citation from the Citable interface
	// Like in printInfo, if there is more thatn 1 author, the citation should have
	// the authors in the format of '[First author] et al.'
	
	@Override
	public void MLACitation() {
		String author = authors[0];
		String formattedName = author;
		
		/*String[] nameParts = authors[0].split(" ");
		String firstName = nameParts[0];
		String lastName = nameParts[nameParts.length-1];
		String formattedName = lastName + ", " + firstName;
		*/
		
		//Checks if there are any spaces in author
		//Prevents one-word authors from beginning with a comma ex. " , Beyonce"
		if (author.contains(" ")) {
			int lastSpace = author.lastIndexOf(" ");
			//Assigns beginning until the space as the first name
			String firstName = author.substring(0, lastSpace);
			//Makes the lastName from the end of the space until the end
			String lastName = author.substring(lastSpace + 1);
			
			//Checks for single author groups like The Culinary Institute of America
			//Prevents it from being formatted lastName, firstName
			if (authors.length == 1 && !authors[0].contains(",") && authors[0].contains(" ")) {
				formattedName = author;
			} else {
				formattedName = lastName + ", " + firstName;
			}
		}
		
		//Checks for multiple authors, adds et al to the end if there are multiple
		if(authors.length > 1) {
			formattedName += ", et al";
		}
	
		//Checks if the last character is a period so code doesn't print an extra period
		//Fuller, Lon L. prints instead of Fuller, Lon L..
		if (formattedName.charAt(formattedName.length() - 1) == '.') {
			formattedName = formattedName.substring(0, formattedName.length() - 1);
		}
		
		System.out.printf("%s. \"%s.\" %s, %d.%n", formattedName, title, journal, publicationYear);
	}
	
}
