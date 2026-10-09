package Bookstore.Publications;

import Bookstore.Interfaces.Printable;

public class Publication implements Comparable<Publication>, Printable{
	// Instance variables
	protected String title;
	protected String genre;

	public Publication(String t, String g){
		title = t;
		genre = g;
	}

	public void printInfo(){
		System.out.printf("%s :: %s%n", title, genre);
	}

	@Override
	public int compareTo(Publication p) {
		if(genre.compareTo(p.genre) == 0){
			return title.compareTo(p.title);
		}

		return genre.compareTo(p.genre);
	}

}
