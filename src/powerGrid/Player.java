package powerGrid;
import java.util.*;
public class Player {
	private int cash, score, orderNumber;
	private ArrayList<PowerPlantCard> cards;
	private String color;
	
	public Player() {
		cash = 50;
		score = 0;
		orderNumber = 0;
		color = "";
	
		cards = new ArrayList<PowerPlantCard>();
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
	public void setCards(ArrayList<PowerPlantCard> cards) {
		this.cards = cards;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public void placePowerPlant(City c) {
		if(c.isIfInPlayableArea()) {
			if(//edgeweight plus city amount is less than cash holdings && numPlayers on city is less than 3 ){
				c.addPlayer(this);
				cash -= //cityAmount + edgeWeight;
				
			
		}
	}
	
	public void buyResource(String type, PowerPlantCard a, int cost) {
		if(type.equals("coal")) {
			if(cost <= cash){
				if(a.getResourceType().equals("coal") && a.getNumResources() < a.getNumRequiredResources() * 2) {
					cash -= cost;
					a.addResource();
				}
			}
		} else if(type.equals("oil")) {
			if(cost <= cash){
				if(a.getResourceType().equals("oil") && a.getNumResources() < a.getNumRequiredResources() * 2) {
					cash -= cost;	
					a.addResource();
				}			
			}
		} else if(type.equals("garbage")) {
			if(cost <= cash){
				if(a.getResourceType().equals("garbage") && a.getNumResources() < a.getNumRequiredResources() * 2) {
					cash -= cost;
					a.addResource();
				}			
			}
		} else {
			if(cost <= cash){
				if(a.getResourceType().equals("uranium") && a.getNumResources() < a.getNumRequiredResources() * 2) {
					cash -= cost;
					a.addResource();
				}			
			}
		}
	}
	
	public void powerPowerPlantCard(PowerPlantCard a) {
		if(a.getNumResources() > a.getNumRequiredResources()) {
			a.setPowered(true);
			a.setNumResources(a.getNumResources() - a.getNumRequiredResources());
		}
	}
	
	public void replacePowerPlantCard(PowerPlantCard a, int index) {
		cards.set(index, a);
		
	
	}
	
	public void buyPowerPlantCard(PowerPlantCard a, int cost) {
		if(cost < cash) {
			cash -= cost;
			if(cards.size() == 3) {
				replacePowerPlantCard(a, have them choose what card to replace)
			}
			else {
				cards.add(a);
			}
	}
	
	
	
	
	
}
