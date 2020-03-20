package powerGrid;

import java.util.*;

import GraphTheory.Vertex;
public class Path {
	private ArrayList<Vertex> path;
	int length;
	int lastEdgeWeight;
	
	public Path(Vertex v) {
		path = new ArrayList<Vertex>();
		path.add(v);
		length = 0;
		lastEdgeWeight = 0;
	}
	
	public Path(Path p) {
		path = new ArrayList<Vertex>();
		for(Vertex v: p.path) {
			path.add(v);
			
		}
		length = p.length;
		lastEdgeWeight = p.lastEdgeWeight;
	}
	
	public Path(Path p, Vertex v) {
		path = new ArrayList<Vertex>();
		for(Vertex g: p.path) {
			path.add(g);
			
		}
		length = p.length;
		
		this.add(v);
		
	}
	
	public void add(Vertex v) {
		if(!path.contains(v)) {
			if(v.neighbors.containsKey(getLastVertex())) {
				length += v.weight(getLastVertex());
				lastEdgeWeight = v.weight(getLastVertex());
				path.add(v);
			}
		}
		else {
			System.out.println(v.getName() + "has already been entered in the path");
		}
	}
	
	public Vertex getLastVertex() {
		return path.get(path.size() - 1);
	}

	public ArrayList<Vertex> getPath() {
		return path;
	}

	public void setPath(ArrayList<Vertex> path) {
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
	
	public Vertex getVertex(int i) {
		return path.get(i);
	}
	
	public String toString() {
		String toReturn = "Path: ";
		for(Vertex v: path) {
			toReturn += v.getName() + " -> ";
		}
		toReturn += "Distance: " + length;
		return toReturn;
	}
	
	
}
