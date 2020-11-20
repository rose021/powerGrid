package powerGrid;
import java.util.ArrayList;
import java.util.HashMap;
public class City {
	private String cityName, color;
	private ArrayList<Player> players;
	HashMap<City, Integer> neighbors;
	private boolean visited;
	
	
	public City(String name, String area) {
		cityName = name;
		players = new ArrayList<Player>();
		color = area;
		neighbors = new HashMap<City, Integer>();
		visited = false;
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void addPlayer(Player player) {
		players.add(player);
	}
	public String area() {
		return color;
	}
	
	public void setVisited(boolean b) {
		visited = b;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
	public void add(City n, int weight) {
		if(neighbors.containsKey(n)) {
			System.out.println(n.cityName + " is already in the neighbors list");
			return;
		} else if(n.cityName.equals(cityName)) {
			System.out.println("Do not add a vertex to its own adjacency list");

		}else {
			neighbors.put(n, weight);
		}
	}
	
	public Integer weight(City n) {
		if(neighbors.containsKey(n)) {
			return (Integer) neighbors.get(n);
		} else {
			return null;
		}
	}
	
	public City[] allNeighbors() {
		City[] a = new City[neighbors.size()];
		int i = 0;
		for(City b : neighbors.keySet()) {
			a[i] = b;
			i++;
		}
		return a;
	}
	
	public String toString() {
		String toReturn = cityName + " (" + color + ")" + ": ";
		for(City key : neighbors.keySet()) {
			toReturn += "<" + key.cityName + " (" + key.color + ")" + ", " + neighbors.get(key) + ">, ";
		}
		return toReturn;
	}
	
	
}
