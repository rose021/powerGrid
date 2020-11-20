package powerGrid;
import java.io.IOException;
import java.util.*;
public class Market {
	private ArrayList<PowerPlantCard> market;
	private PowerPlantCardDeck p;
	
	public Market() {
		market = new ArrayList<PowerPlantCard>();
		try {
			p = new PowerPlantCardDeck("src/powerGrid/PowerGridCards.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 8; i++) {
			market.add(p.draw());
		}
		p.afterMarket();
	}
	
	public ArrayList<PowerPlantCard> getMarket() {
		return market;
	}

	public void setMarket(ArrayList<PowerPlantCard> market) {
		this.market = market;
	}
	
	public int getIndex(PowerPlantCard a) {
		for(int i = 0; i < market.size(); i++) {
			if(market.get(i).equals(a)) {
				return i;
			}
		}
		return -1;
	}
	
	public void replaceCard(PowerPlantCard a, int index) {
		market.remove(index);
		market.add(a);
		reorder();
	}
	
	public PowerPlantCard get(int index) {
		return market.get(index);
	}
	

	public void buyPowerPlantCard(PowerPlantCard a, Player b, int index, int step, int price) {
		
		/*
		if(a.getMinBid() <= b.getCash()) {
			if(step != 3 ) {
				if(getIndex(a) < 4) {
					b.setCash(b.getCash() - a.getMinBid());
					if(b.getCards().size() == 3) {
						b.replacePowerPlantCard(a, index);
					}
					else {
						b.addCard(a);
					}
					replaceCard(p.draw(), getIndex(a));
				} else {
					System.out.println("cannot get from future market");
				}
			} else {
				b.setCash(b.getCash() - a.getMinBid());
				if(b.getCards().size() == 3) {
					b.replacePowerPlantCard(a, index);
				}
				else {
					b.addCard(a);
				}
				replaceCard(p.draw(), getIndex(a));
			}
		}*/
	}
	public boolean checker(PowerPlantCard a, Player b, int index, int step, int price) {
		if(price <= b.getCash()) {
			if(step != 3 ) {
				if(getIndex(a) < 4) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
		return false;
	}
	

	
	public void endOfRoundStepsOneAndTwo() {
		market.remove(market.size() - 1);
		market.add(p.draw());
		reorder();
	}
	
	public void endOfRoundStepThree() {
		if(market.size() > 0) {
			market.remove(0);
			if(p.getDeck().size() > 0) {
				market.add(p.draw());
				reorder();
			}
		}
	}
	
	public void checkScores(ArrayList<Player> a) {
		int max = 0;
		for(Player b : a) {
			if(b.getScore() > max) {
				max = b.getScore();
			}
		}
		for(int j = 0; j < market.size(); j++) {
			if(max >= market.get(j).getMinBid() && market.size() > 0) {
				market.remove(j);
				if(p.getDeck().size() > 0) {
					market.add(p.draw());
					reorder();
					j = -1;
				}
			}
		}
	}
	
	public void stepTwo() {
		market.remove(0);
		market.add(p.draw());
		reorder();
	}
	
	public void stepThree() {
		p.shuffle();
		market.remove(0);
	}
	
	private void reorder() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8 - i - 1; j++) {
				if(market.get(j).compareTo(market.get(j + 1)) > 0) {
					PowerPlantCard a = market.get(j);
					market.set(j, market.get(j + 1));
					market.set(j + 1, a);
				}
			}
		}
	}
	public PowerPlantCardDeck getP() {
		return p;
	}
}
