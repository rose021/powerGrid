package powerGrid;
import java.util.ArrayList;
public class City {
	private String cityName;
	private ArrayList<Player> players;
	private boolean ifInPlayableArea;
	
	public City(String name, String area) {
		cityName = name;
		players = new ArrayList<Player>();
		
		ifinplayablearea
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
	public boolean isIfInPlayableArea() {
		return ifInPlayableArea;
	}
	public void setIfInPlayableArea(boolean ifInPlayableArea) {
		this.ifInPlayableArea = ifInPlayableArea;
	}
	
	
}
