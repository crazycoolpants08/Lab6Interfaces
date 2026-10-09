// Student Name: Heidi Faustermann
// LSU ID: 891648160
// Assignment: Lab 6 Interfaces

package Bookstore;

import java.util.ArrayList;
import java.util.Collections;

import Bookstore.Publications.Publication;

public class Inventory {
	private ArrayList<Publication> publications;

	public Inventory(){
		publications = new ArrayList<>();
	}

	public void addPublication(Publication p){
		publications.add(p);
	}

	public void listInventory(){
		Collections.sort(publications);
		for(Publication pub: publications){
			pub.printInfo();
		}
	}

	public void printBibliography(){
		// TODO - Using the instance of keyword,
		// print the MLA citation of every citable
		// element in the Inventory
		
		//Checks if each element needs an MLA citation, prints the MLA citation if it does
		for(Publication pub : publications) {
			if (pub instanceof Bookstore.Interfaces.Citable) {
				((Bookstore.Interfaces.Citable)pub).MLACitation();
			}
		}
	}
}
