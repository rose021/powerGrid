package powerGrid;

import java.util.*;
public class Vertex {
	String name;
	boolean visited;
	HashMap<Vertex, Integer> neighbors;
	
	public Vertex(String name) {
		this.name = name;
		visited = false;
		neighbors = new HashMap<Vertex, Integer>();
		
		
	}
	
	public void add(Vertex n, int weight) {
		if(neighbors.containsKey(n)) {
			System.out.println(n.name + " is already in the neighbors list");
			return;
		} else if(n.name.equals(name)) {
			System.out.println("Do not add a vertex to its own adjacency list");

		}else {
			neighbors.put(n, weight);
		}
	}
	
	public Integer weight(Vertex n) {
		if(neighbors.containsKey(n)) {
			return (Integer) neighbors.get(n);
		} else {
			return null;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
	public void setName(String n) {
		name = n;
	}
	public void setVisited(boolean b) {
		visited = b;
	}
	
	
	public Vertex[] allNeighbors() {
		Vertex[] a = new Vertex[neighbors.size()];
		int i = 0;
		for(Vertex b : neighbors.keySet()) {
			a[i] = b;
			i++;
		}
		return a;
	}
	
	public String toString() {
		String toReturn = name + ": ";
		for(Vertex key : neighbors.keySet()) {
			toReturn += "<" + key.name + ", " + neighbors.get(key) + ">, ";
		}
		return toReturn;
	}
}
