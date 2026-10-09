// Student Name: Heidi Faustermann
// LSU ID: 891648160
// Assignment: Lab 6 Interfaces

package Bookstore.Publications;

import Bookstore.Interfaces.Citable;

public class Music extends Publication implements Citable{
	private String artist;
	private String lengthType;

	public Music(String t, String g, String a, String lT){
		super(t, g);
		artist = a;
		lengthType = lT;
	}

	@Override
	public void printInfo(){
		System.out.printf("%s is a %s by %s :: %s", title, lengthType, artist, genre);
	}

	// TODO - Implement the MLA Citation from the Citable interface
	@Override
	public void MLACitation() {
		//Checks if it is a song or an album
		//equalsIgnoreCase prevents from errors because of capitalization
		if (lengthType.equalsIgnoreCase("Single")) {
			//Adds quotes around title if it is a single
			System.out.printf("%s. \"%s.\" %s.%n", artist, title, lengthType);
		} else {
			System.out.printf("%s. %s. %s.%n", artist, title, lengthType);
		}
	}
}
