package powerGrid;
import java.util.ArrayList;
public class City {
	private String cityName, color;
	private ArrayList<Player> players;
	
	
	public City(String name, String area) {
		cityName = name;
		players = new ArrayList<Player>();
		color = area;
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
	
	
	
}
