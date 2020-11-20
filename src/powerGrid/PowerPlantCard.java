package powerGrid;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.awt.*;
public class PowerPlantCard implements Comparable{
	private boolean powered;
	private int minBid, numRequiredResources, numResources, numPoweredPlants;
	private String resourceType, fileName;
	private BufferedImage image;
	private ArrayList<Rectangle> resources;
	private ArrayList<String> resourceTypes;
	
	public PowerPlantCard(int min, int required, int plants, String type, String fn) {
		powered = false;
		minBid = min;
		numRequiredResources = required;
		numResources = 0;
		numPoweredPlants = plants;
		resourceType = type;
		fileName = fn;
		resources = new ArrayList<Rectangle>();
		resourceTypes = new ArrayList<String>();
		
		try {
			image = ImageIO.read(new File("Cards/" + fn));
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public int getNumRequiredResources() {
		return numRequiredResources;
	}
	public int getNumResources() {
		return numResources;
	}
	
	
	
	public ArrayList<Rectangle> getResources() {
		return resources;
	}


	public ArrayList<String> getResourceTypes() {
		return resourceTypes;
	}

	public void useResources() {
		numResources -= numRequiredResources;
		for(int i = 0; i < numRequiredResources; i++) {
			resources.remove(resources.size() - 1);
			resourceTypes.remove(resourceTypes.size() - 1);
		}
	}
	
	public void addResource(Rectangle r, String type) {
		if(numResources < numRequiredResources * 2) {
			numResources++;
			resources.add(r);
			resourceTypes.add(type);
		}
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
	
	public boolean equals(Object o) {
		PowerPlantCard other = (PowerPlantCard) o;
		boolean a = (this.minBid == other.minBid);
		return a;
	}
	
	
	public String toString() {
		return "Minimum bid: " + minBid + ", Number of required resources: " + numRequiredResources +
				", Resource Type: "+ resourceType + ", Number of resources on card: " + numResources + ", Number of plants this powers: " + numPoweredPlants;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		PowerPlantCard other = (PowerPlantCard) o;
		return minBid - other.minBid;
	}
	
	
}
