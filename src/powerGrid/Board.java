package powerGrid;

import java.util.ArrayList;

public class Board {
	private ArrayList<Player> players;
	
	public Board() {
		players = new ArrayList<Player>();
	}
	
	public void addPlayer() {
		Player a = new Player();
		if(players.size() == 0) {
			a.setColor("blue");
		} else if(players.size() == 1) {
			a.setColor("red");
		} else if(players.size() == 2) {
			a.setColor("purple");
		} else if(players.size() == 3) {
			a.setColor("yellow");
		} else if(players.size() == 4) {
			a.setColor("green");
		} else if(players.size() == 5) {
			a.setColor("brown");
		} else {
			System.out.println("too many players");
			return;
		}
		players.add(a);
		a.setOrderNumber(players.size());
	}
}

