package powerGrid;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Board {
	private ArrayList<Player> players;
	private ArrayList<String> areas;
	private int step;
	private AdjacencyList cities;
	private Market market;
	
	public Board() {
		market = new Market();
		areas = new ArrayList<String>();
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Yellow");
		colors.add("Green");
		colors.add("Purple");
		colors.add("Brown");
		players = new ArrayList<Player>();
		players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
		if(players.get(0).getColor().equals("Brown")) {
			colors.remove(1);
		} else if(players.get(0).getColor().equals("Blue")) {
			colors.remove(4);
		}
		players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
		if((players.get(0).getColor().equals("Green") && players.get(1).getColor().equals("Brown"))) {
			colors.remove(1);
			colors.remove(2);
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));

		} else if((players.get(0).getColor().equals("Brown") && players.get(1).getColor().equals("Green"))) {
			colors.remove(2);
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Green") && players.get(1).getColor().equals("Yellow")) || 
				(players.get(0).getColor().equals("Yellow") && players.get(1).getColor().equals("Green"))) {
			colors.remove(1);
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Green") && players.get(1).getColor().equals("Red")) || 
				(players.get(0).getColor().equals("Red") && players.get(1).getColor().equals("Green"))) {
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Green") && players.get(1).getColor().equals("Purple")) || 
				(players.get(0).getColor().equals("Purple") && players.get(1).getColor().equals("Green"))) {
			colors.remove(1);
			colors.remove(2);
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Green") && players.get(1).getColor().equals("Blue")) || 
				(players.get(0).getColor().equals("Blue") && players.get(1).getColor().equals("Green"))) {
			players.add(new Player("Red"));
			
		} else if((players.get(0).getColor().equals("Brown") && players.get(1).getColor().equals("Yellow")) || 
				(players.get(0).getColor().equals("Yellow") && players.get(1).getColor().equals("Brown"))) {
			colors.remove(1);
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Red") && players.get(1).getColor().equals("Brown"))) {
			colors.remove(0);
			colors.remove(2);
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Brown") && players.get(1).getColor().equals("Red"))) {
			colors.remove(0);
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
		} else if((players.get(0).getColor().equals("Brown") && players.get(1).getColor().equals("Purple")) || 
				(players.get(0).getColor().equals("Purple") && players.get(1).getColor().equals("Brown"))) {
			players.add(new Player("Yellow"));
			
		} else if((players.get(0).getColor().equals("Yellow") && players.get(1).getColor().equals("Red")) || 
				(players.get(0).getColor().equals("Red") && players.get(1).getColor().equals("Yellow"))) {
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Yellow") && players.get(1).getColor().equals("Purple")) || 
				(players.get(0).getColor().equals("Purple") && players.get(1).getColor().equals("Yellow"))) {
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Yellow") && players.get(1).getColor().equals("Blue")) || 
				(players.get(0).getColor().equals("Blue") && players.get(1).getColor().equals("Yellow"))) {
			colors.remove(1);
			if(colors.contains("Brown")) {
				colors.remove(2);
			}
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Red") && players.get(1).getColor().equals("Purple")) || 
				(players.get(0).getColor().equals("Purple") && players.get(1).getColor().equals("Red"))) {
			colors.remove(3);
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Red") && players.get(1).getColor().equals("Blue")) || 
				(players.get(0).getColor().equals("Blue") && players.get(1).getColor().equals("Red"))) {
			if(colors.contains("Brown")) {
				colors.remove(3);
			}
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
			
		} else if((players.get(0).getColor().equals("Purple") && players.get(1).getColor().equals("Blue")) || 
				(players.get(0).getColor().equals("Blue") && players.get(1).getColor().equals("Purple"))) {
			colors.remove(2);
			if(colors.contains("Brown")) {
				colors.remove(2);
			}			
			players.add(new Player(colors.remove((int) (Math.random() * colors.size()))));
		} 
		step = 1;
		try {
			cities = new AdjacencyList("src/powerGrid/citylist");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(players.get(0).getColor());
		System.out.println(players.get(1).getColor());
		System.out.println(players.get(2).getColor());
		areas.add(players.get(0).getColor());
		areas.add(players.get(1).getColor());
		areas.add(players.get(2).getColor());

		
	}
	
	
	public ArrayList<String> getAreas() {
		return areas;
	}


	public void setAreas(ArrayList<String> areas) {
		this.areas = areas;
	}


	public int getStep() {
		return step;
	}


	public void setStep(int step) {
		this.step = step;
	}


	public AdjacencyList getCities() {
		return cities;
	}


	public void setCities(AdjacencyList cities) {
		this.cities = cities;
	}


	public Market getMarket() {
		return market;
	}


	public void setMarket(Market market) {
		this.market = market;
	}


	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public void changePlayerOrder() {
		ArrayList<Player> orderer = new ArrayList(players);
		players = new ArrayList<Player>();
		int max = -1;
		int maxIndex = -1;
		Player maxPlayer = null;
		Player second = null;
		Player third = null;
		
		maxPlayer = orderer.get(findMaxIndex(orderer));
		orderer.remove(findMaxIndex(orderer));
		second = orderer.get(findMaxIndex(orderer));
		orderer.remove(findMaxIndex(orderer));
		third = orderer.get(0);
		players.add(maxPlayer);
		players.add(second);
		players.add(third);
	}
	
	public int findMaxIndex(ArrayList<Player> p) {
		int max = -1;
		int maxIndex = -1;
		Player maxPlayer = null;
		for(int i = 0; i < p.size(); i++) {
			if(p.get(i).getScore() > max) {
				max = p.get(i).getScore();
				maxPlayer = p.get(i);
				maxIndex = i;
			} else if(p.get(i).getScore() == max) {
				int maxCard1 = 0;
				int maxCard2 = 0;
				for(int j = 0; j < maxPlayer.getCards().size(); j++) {
					if(maxPlayer.getCards().get(j).getMinBid() > maxCard1) {
						maxCard1 = maxPlayer.getCards().get(j).getMinBid();
					}
				}
				for(int j = 0; j < p.get(i).getCards().size(); j++) {
					if(p.get(i).getCards().get(j).getMinBid() > maxCard2) {
						maxCard2 = p.get(i).getCards().get(j).getMinBid();
					}
				}
				if(maxCard1 < maxCard2) {	
					maxPlayer = p.get(i);
					maxIndex = i;
				}
				
			}
		}
		return maxIndex;
	}
	
	public void updateScores() {
		for(Player p: players) {
			p.setScore(Math.min(p.getNumPowerPlants(), p.getNumPlantsPowered()));
			if(p.getScore() >= 7 && step == 1) {
				step = 2;
				market.stepTwo();
			}
		}
		int max = 0;
		Player maxPlayer = new Player("Black");
		for(Player p : players) {
			if(p.getScore() >= 17 && p.getScore() >= maxPlayer.getScore()) {
				maxPlayer = p;
				max = p.getScore();
			}
			if(max >= 17) {
				JOptionPane g = new JOptionPane(maxPlayer.getColor() + " Wins!!!");

			}
		}
		for(Player p: players) {
			p.setNumPlantsPowered();
		}
	}
	
	public void addPowerPlant(String c, Player p) {
		GraphTraverser grapher = new GraphTraverser();
		City city = cities.getCity(c);
		ArrayList<Player> x = city.getPlayers();
		ArrayList<Path> paths = new ArrayList<Path>();
		DijkstraComparator a = new DijkstraComparator();
		MyPQ<Path> s = new MyPQ<Path>(a);
		paths = grapher.traverse(s, cities, c);
		cities.reset();
		int edgeWeight = 0;
		
		if(p.getNumPowerPlants() > 0) {
			Path mainPath = null;
			for(Path g : paths) {
				for(int i = 0; i < g.getLastVertex().getPlayers().size(); i++) {
					if(g.getLastVertex().getPlayers().get(i).getColor().equals(p.getColor())) {
						mainPath = g;
					}
				}
				if(mainPath != null) {
					break;
				}
			}
			System.out.println(" Hhhhhh " + mainPath);
			if(mainPath != null) {
				edgeWeight =  mainPath.getLength();
			}
		} else {
			edgeWeight = 0;
		}
		
		if(x.size() < step) {
			int cityAmount = (x.size() + 2)  * 5;
			if(areas.contains(city.area())) {
				if(edgeWeight + cityAmount <= p.getCash()){
					
					p.setCash(p.getCash() - (cityAmount + edgeWeight));
					city.addPlayer(p);
					p.setNumPowerPlants(p.getNumPowerPlants() + 1);
				}		
					
				
			}
		}
	}
	
}

