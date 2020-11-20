package powerGrid;
import java.util.*;
public class Player {
	private int cash, score, orderNumber, numPowerPlants, numPlantsPowered;
	private ArrayList<PowerPlantCard> cards;
	private String color;
	private boolean gotCardThisRound;
	
	
	public Player(String color) {
		cash = 50;
		score = 0;
		orderNumber = 0;
		this.color = color;
		numPlantsPowered = 0;
		numPowerPlants = 0;
		gotCardThisRound = false;
		
		cards = new ArrayList<PowerPlantCard>();
	}
	
	
	
	public boolean isGotCardThisRound() {
		return gotCardThisRound;
	}



	public void setGotCardThisRound(boolean gotCardThisRound) {
		this.gotCardThisRound = gotCardThisRound;
	}



	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public ArrayList<PowerPlantCard> getCards() {
		return cards;
	}
	public void addCard(PowerPlantCard card) {
		cards.add(card);
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getNumPowerPlants() {
		return numPowerPlants;
	}

	public void setNumPowerPlants(int numPowerPlants) {
		this.numPowerPlants = numPowerPlants;
	}

	public int getNumPlantsPowered() {
		return numPlantsPowered;
	}

	public void setNumPlantsPowered() {
		int numPowered = 0;
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).isPowered()) {
				numPowered += cards.get(i).getNumPoweredPlants();
				cards.get(i).setPowered(false);

			}
		}
		numPlantsPowered = numPowered;
	}

	
	
	public void powerPowerPlantCard(PowerPlantCard a) {
		if(a.getNumResources() >= a.getNumRequiredResources()) {
			a.setPowered(true);
			a.useResources();
		}
	}
	
	public void replacePowerPlantCard(PowerPlantCard a, int index) {
		cards.set(index, a);
		
	
	}
	
	public Player compare(Player p) {
		int max = 0;
		Player maxPlayer = null;
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).getMinBid() > max) {
				max = cards.get(i).getMinBid();
				maxPlayer = this;
			}
		}
		
		for(int i = 0; i < p.getCards().size(); i++) {
			if(p.getCards().get(i).getMinBid() > max) {
				max = cards.get(i).getMinBid();
				maxPlayer = p;
			}
		}
		
		return maxPlayer;
	}
	
	
	
	
	
	
	
}
