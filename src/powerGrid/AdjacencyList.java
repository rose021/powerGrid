package powerGrid;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class AdjacencyList {

	private ArrayList<City> cities;
	private Scanner s;
	
	public AdjacencyList(String fn) throws IOException{ //takes in the file you want to be read

		cities = new ArrayList<City>();

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
			
			
			if(getCity(a[0]) == null || !cities.contains(getCity(a[0]))) {
				cities.add(new City(a[0], a[1]));
				for(int i = 0; i < cities.size(); i++) {
					if(getCity(a[2]) == null) {
						cities.add(new City(a[2], a[3]));
					}
					if(!a[0].equals(a[2])) {
						if(cities.get(i).getCityName().equals(a[0])) {
							cities.get(i).add(getCity(a[2]), Integer.parseInt(a[4]));
						} else if(cities.get(i).getCityName().equals(a[1])) { 
							cities.get(i).add(getCity(a[0]), Integer.parseInt(a[4]));
						}
					}
				}	
				
			} else {
				for(int i = 0; i < cities.size(); i++) {
					if(getCity(a[2]) == null) {
						cities.add(new City(a[2], a[3]));
					}
					if(!a[0].equals(a[1])) {
						if(cities.get(i).getCityName().equals(a[0])) {
							cities.get(i).add(getCity(a[2]), Integer.parseInt(a[4]));
						} else if(cities.get(i).getCityName().equals(a[2])) {
							cities.get(i).add(getCity(a[0]), Integer.parseInt(a[4]));
						}
					}
				
			}
		}//read one in

			//process (parse) string

			//make vertex(es)

			//add vertex to list, being careful about duplicates

		}
	}
	
	public City getCity(String name){
		for(City a : cities) {
			if(a.getCityName().equals(name)) {
				return a;
			}
		}
		return null;
	}
	
	public void reset(){
		for(City a : cities) {
			a.setVisited(false);
		}
	}
	
	public String toString(){
		String a = "";
		for(City b : cities) {
			a += b.toString() + "\n";
		}
		return a;
	}
	
	public int size() {
		return cities.size();
	}
	
	public static void main(String[] args){
		AdjacencyList aL = null;
		try {
			aL = new AdjacencyList("src/powerGrid/citylist");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(aL.toString());
		System.out.println(aL.getCity("A"));
		
	}
}
