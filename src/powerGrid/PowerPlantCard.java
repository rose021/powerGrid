package powerGrid;

public class PowerPlantCard {
	private boolean powered;
	private int minBid, numRequiredResources, numResources, numPoweredPlants;
	private String resourceType;
	//image
	
	public PowerPlantCard(int min, int required, int num, int plants, String type) {
		powered = false;
		minBid = min;
		numRequiredResources = required;
		numResources = num;
		numPoweredPlants = plants;
		resourceType = type;
	}
	
	public boolean isPowered() {
		return powered;
	}
	public void setPowered(boolean powered) {
		this.powered = powered;
	}
	public int getMinBid() {
		return minBid;
	}
	public void setMinBid(int minBid) {
		this.minBid = minBid;
	}
	public int getNumRequiredResources() {
		return numRequiredResources;
	}
	public void setNumRequiredResources(int numRequiredResources) {
		this.numRequiredResources = numRequiredResources;
	}
	public int getNumResources() {
		return numResources;
	}
	public void setNumResources(int numResources) {
		this.numResources = numResources;
	}
	
	public void addResource() {
		numResources++;
	}
	public int getNumPoweredPlants() {
		return numPoweredPlants;
	}
	public void setNumPoweredPlants(int numPoweredPlants) {
		this.numPoweredPlants = numPoweredPlants;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
	
}
