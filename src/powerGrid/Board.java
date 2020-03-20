package powerGrid;

import java.util.ArrayList;

public class Board {
	private ArrayList<Player> players;
	private int numCoalAvailable, numOilAvailable, numGarbageAvailable, numUraniumAvailable, step;
	private ArrayList<Integer> playerOrder, Scores;
	
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
	
	public void changePlayerOrder() {
		//player with highest score is first, followed by others in score order
		//If there is a tie, the person with the highest number PowerPlantCard goes first
	}
	
	public void updateScores() {
		for(Player p: players) {
			//for each power plant that they powered, they get one point
		}
	}
	public void addPowerPlant(City c, Player p) {
		ArrayList<Player> x = c.getPlayers();
		//use dijkstra's algorithm to find least cost path from player's nearest powerplant to here
		
		if(c.isIfInPlayableArea()) {
			if(/*edgeweight plus city amount is less than cash holdings && x.size() < step*/){
				
				p.setCash(p.getCash() - //cityAmount + edgeWeight);
			}		
				
			
		}
	}	
}

