// Student Name: Heidi Faustermann
// LSU ID: 891648160
// Assignment: Lab 6 Interfaces

package Bookstore.Publications;

import Bookstore.Interfaces.Citable;

public class Magazine extends Publication implements Citable{
	private int issue;
	private int volume;
	private String publisher;

	public Magazine(String t, String g, int i, int v, String p){
		super(t, g);
		issue = i;
		volume = v;
		publisher = p;
	}

	@Override
	public void printInfo() {
		System.out.printf("%s was published by %s in Volume %d issue %d :: %s%n", title, publisher, volume, issue, genre);
	}

	// TODO - Implement the MLA Citation from the Citable interface
	@Override
	public void MLACitation() {
		System.out.printf("\"%s.\" %s, vol. %d, no. %d.%n", title, publisher, volume, issue);
	}
	
}
