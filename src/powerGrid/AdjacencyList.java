package powerGrid;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class AdjacencyList {

	private ArrayList<Vertex> vertexes;
	private Scanner s;
	
	public AdjacencyList(String fn) throws IOException{ //takes in the file you want to be read

		vertexes = new ArrayList<Vertex>();

		//Scanner fscan = new Scanner(new File(fn)); //initiates file scanner
		//while(fscan.hasNextLine()){ //while there are still lines left in the file
			//String line = fscan.nextLine();
		try {
			s = new Scanner(new File(fn));
		} catch(Exception e) {
			System.out.println("there was a problem scanning the file");
			e.printStackTrace();
		}
		while(s.hasNextLine()) {
			String[] a = s.nextLine().split(" ");
			
			
			if(getVertex(a[0]) == null || !vertexes.contains(getVertex(a[0]))) {
				vertexes.add(new Vertex(a[0]));
				for(int i = 0; i < vertexes.size(); i++) {
					if(getVertex(a[1]) == null) {
						vertexes.add(new Vertex(a[1]));
					}
					if(!a[0].equals(a[1])) {
						if(vertexes.get(i).name.equals(a[0])) {
							vertexes.get(i).add(getVertex(a[1]), Integer.parseInt(a[2]));
						} else if(vertexes.get(i).name.equals(a[1])) {
							vertexes.get(i).add(getVertex(a[0]), Integer.parseInt(a[2]));
						}
					}
				}	
				
			} else {
				for(int i = 0; i < vertexes.size(); i++) {
					if(getVertex(a[1]) == null) {
						vertexes.add(new Vertex(a[1]));
					}
					if(!a[0].equals(a[1])) {
						if(vertexes.get(i).name.equals(a[0])) {
							vertexes.get(i).add(getVertex(a[1]), Integer.parseInt(a[2]));
						} else if(vertexes.get(i).name.equals(a[1])) {
							vertexes.get(i).add(getVertex(a[0]), Integer.parseInt(a[2]));
						}
					}
				
			}
		}//read one in

			//process (parse) string

			//make vertex(es)

			//add vertex to list, being careful about duplicates

		}
	}
	
	public Vertex getVertex(String name){
		for(Vertex a : vertexes) {
			if(a.name.equals(name)) {
				return a;
			}
		}
		return null;
	}
	
	public void reset(){
		for(Vertex a : vertexes) {
			a.visited = false;
		}
	}
	
	public String toString(){
		String a = "";
		for(Vertex b : vertexes) {
			a += b.toString() + "\n";
		}
		return a;
	}
	
	public int size() {
		return vertexes.size();
	}
	
	public static void main(String[] args){
		AdjacencyList aL = null;
		try {
			aL = new AdjacencyList("src/graph1.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(aL.toString());
		System.out.println(aL.getVertex("A"));
		
	}
}
