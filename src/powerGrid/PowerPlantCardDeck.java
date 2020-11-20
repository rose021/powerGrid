package powerGrid;
import java.util.*;
import java.io.*;
public class PowerPlantCardDeck {
	private ArrayList<PowerPlantCard> cards;
	private MyQ<PowerPlantCard> deck;
	private Scanner s;
	private PowerPlantCard a, b;
	
	public PowerPlantCardDeck(String fn) throws IOException {
		cards = new ArrayList<PowerPlantCard>();
		
		try {
			s = new Scanner(new File(fn));
		} catch(Exception e) {
			System.out.println("there was a problem scanning the file");
			e.printStackTrace();
		}
		
		while(s.hasNextLine()) {
			String[] a = s.nextLine().split(",");
			cards.add(new PowerPlantCard(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]), a[3], a[4]));
		}
		
		deck = new MyQ<PowerPlantCard>();
		for(int i = 0; i <= 7; i++) {
			deck.add(cards.remove(0));
			
		}
		a = cards.remove(2);
		b = cards.remove(cards.size() - 1);
		for(int i = 0; i < 8; i++) {
			cards.remove((int) (Math.random() * cards.size()));
		}
		while(cards.size() > 0) {	
			deck.add(cards.remove((int) (Math.random() * cards.size())));
		}
	}
	
	public void afterMarket() {
		deck.addToFront(a);
		deck.add(b);
	}
	
	
	public MyQ<PowerPlantCard> getDeck() {
		return deck;
	}
	
	public String toString() {
		String a = "";
		for(int i = 0; i < deck.size(); i++) {
			if(deck.get(i).equals(new PowerPlantCard(0, 0, 0, "None", "step3.png"))) {
				a += "Step 3";
			} else {
				a += deck.get(i) + "\n";
			}
			
		}
		return a;
	}
	
	public PowerPlantCard draw() {
		return deck.remove();
	}
	
	public void add(PowerPlantCard p) {
		deck.add(p);
	}
	
	public void shuffle() {
		for(int i = 0; i < deck.size(); i++) {
			cards.add(deck.remove());
		}
		while(cards.size() > 0) {	
			deck.add(cards.remove((int) (Math.random() * cards.size())));
		}	
	}
	
	public static void main(String[] args) {
		PowerPlantCardDeck p = null;
		try {
			p = new PowerPlantCardDeck("src/powerGrid/PowerGridCards.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(p);
		System.out.println();
		p.shuffle();
		System.out.println(p);
		
	}
}
