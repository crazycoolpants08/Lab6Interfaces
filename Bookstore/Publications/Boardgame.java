// Student Name: Heidi Faustermann
// LSU ID: 891648160
// Assignment: Lab 6 Interfaces

package Bookstore.Publications;

public class Boardgame extends Publication{
	private int minPlayers;
	private int maxPlayers;
	private int minTimeToPlay;
	private int maxTimeToPlay;

	public Boardgame(String t, String g, int miP, int maP, int miTTP, int maTTP){
		super(t, g);
		minPlayers = miP;
		maxPlayers = maP;
		minTimeToPlay = miTTP;
		maxTimeToPlay = maTTP;
	}

	@Override
	public void printInfo(){
		System.out.printf("%s is a %d-%d player game that takes %d-%d mintues to play :: %s%n", title, minPlayers, maxPlayers, minTimeToPlay, maxTimeToPlay, genre);
	}
}
