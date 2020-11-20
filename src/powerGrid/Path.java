package powerGrid;

import java.util.*;
public class Path {
	private ArrayList<City> path;
	int length;
	int lastEdgeWeight;
	
	public Path(City v) {
		path = new ArrayList<City>();
		path.add(v);
		length = 0;
		lastEdgeWeight = 0;
	}
	
	public Path(Path p) {
		path = new ArrayList<City>();
		for(City v: p.path) {
			path.add(v);
			
		}
		length = p.length;
		lastEdgeWeight = p.lastEdgeWeight;
	}
	
	public Path(Path p, City v) {
		path = new ArrayList<City>();
		for(City g: p.path) {
			path.add(g);
			
		}
		length = p.length;
		
		this.add(v);
		
	}
	
	public void add(City v) {
		if(!path.contains(v)) {
			if(v.neighbors.containsKey(getLastVertex())) {
				length += v.weight(getLastVertex());
				lastEdgeWeight = v.weight(getLastVertex());
				path.add(v);
			}
		}
		else {
			System.out.println(v.getCityName() + "has already been entered in the path");
		}
	}
	
	public City getLastVertex() {
		return path.get(path.size() - 1);
	}

	public ArrayList<City> getPath() {
		return path;
	}

	public void setPath(ArrayList<City> path) {
		this.path = path;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLastEdgeWeight() {
		return lastEdgeWeight;
	}

	public void setLastEdgeWeight(int lastEdgeWeight) {
		this.lastEdgeWeight = lastEdgeWeight;
	}
	
	public int getNumVertexes() {
		return path.size();
	}
	
	public City getVertex(int i) {
		return path.get(i);
	}
	
	public String toString() {
		String toReturn = "Path: ";
		for(City v: path) {
			toReturn += v.getCityName() + " -> ";
		}
		toReturn += "Distance: " + length;
		return toReturn;
	}
	
	
}
