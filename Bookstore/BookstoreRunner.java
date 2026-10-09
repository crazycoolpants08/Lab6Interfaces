// Student Name: Heidi Faustermann
// LSU ID: 891648160
// Assignment: Lab 6 Interfaces

package Bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Bookstore.Enums.PublicationTypes;
import Bookstore.Publications.Boardgame;
import Bookstore.Publications.Book;
import Bookstore.Publications.Magazine;
import Bookstore.Publications.Music;
import Bookstore.Publications.Publication;
import Bookstore.Publications.Research;

public class BookstoreRunner {
	public static void main(String[] args) throws FileNotFoundException{
		Inventory bookStore = populatePublications();

		bookStore.listInventory();
		System.out.println("========================================================");
		bookStore.printBibliography();
	}

	public static Inventory populatePublications() throws FileNotFoundException{
		Inventory i = new Inventory();
		File infile = new File("./Data/items.tsv");
		Scanner input = new Scanner(infile);

		while(input.hasNextLine()){
			String productInfo = input.nextLine();
			if(!productInfo.replace("\s", "").isEmpty()){
				i.addPublication(publicationFactory(productInfo));
			}
		}

		return i;
	}

	public static Publication publicationFactory(String dataString){
		String[] data = dataString.split("\t");

		switch(PublicationTypes.valueOf(data[0].toUpperCase())){
			case PUBLICATION:
				return new Publication(
					data[1],
					data[2]
				);
			case BOOK:
				return new Book(
					data[1],
					data[2],
					data[3],
					data[4],
					Integer.parseInt(data[5])
				);
			case MAGAZINE:
				return new Magazine(
					data[1],
					data[2],
					Integer.parseInt(data[3]),
					Integer.parseInt(data[4]),
					data[5]
				);
			case RESEARCH:
				return new Research(
					data[1],
					data[2],
					data[3].split(","),
					data[4],
					Integer.parseInt(data[5])
				);
			case BOARDGAME:
				return new Boardgame(
					data[1],
					data[2],
					Integer.parseInt(data[3]),
					Integer.parseInt(data[4]),
					Integer.parseInt(data[5]),
					Integer.parseInt(data[6])
				);
			case MUSIC:
				return new Music(
					data[1],
					data[2],
					data[3],
					data[4]
				);
		}

		return null;

	}

}
