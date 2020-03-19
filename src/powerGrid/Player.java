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
	
	public void buyResource(String type, PowerPlantCard a) {
		if(type.equals("coal")) {
			if(//amount is less than cash){
				if(a.resourceType.equals("coal") && a.numResources < a.numRequiredResources * 2) {
					cash -= //amount for coal;
					a.addResource();
				}
			}
		} else if(type.equals("oil")) {
			if(//amount is less than cash){
				if(a.resourceType.equals("oil") && a.numResources < a.numRequiredResources * 2) {
					cash -= //amount for oil;	
					a.addResource();
				}			
			}
		} else if(type.equals("garbage")) {
			if(//amount is less than cash){
				if(a.resourceType.equals("garbage") && a.numResources < a.numRequiredResources * 2) {
					cash -= //amount for garbage;
					a.addResource();
				}			
			}
		} else {
			if(//amount is less than cash){
				if(a.resourceType.equals("uranium") && a.numResources < a.numRequiredResources * 2) {
					cash -= //amount for uranium;
					a.addResource();
				}			
			}
		}
	}
	
	public void powerPowerPlantCard(PowerPlantCard a) {
		if(a.numResources > a.numRequiredResources) {
			a.setPowered(true);
			a.setNumResources(a.numResources - numRequiredResources);
		}
	}
	
	public void replacePowerPlantCard(PowerPlantCard a, int index) {
		cards.set(index, a);
		
	
	}
	
	
	
	
	
}
