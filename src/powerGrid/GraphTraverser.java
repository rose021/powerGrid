package powerGrid;

import java.util.*;

public class GraphTraverser {
	private ArrayList<Path> results;
	
	public GraphTraverser() {
		results = new ArrayList<Path>();
	}
	
	public ArrayList<Path> traverse(DataStructure<Path> ds, AdjacencyList graph, String startName){
		Path a = new Path(graph.getCity(startName));
		ds.add(a);
		while(ds.isEmpty() == false) {
			Path b = ds.remove();
			City e = b.getLastVertex();
			if(e.getVisited() == false) {
				e.setVisited(true);
				results.add(b);
				for(City c : e.allNeighbors()) {
					if(c.getVisited() == false) {
						Path newPath = new Path(b, c);
						ds.add(newPath);
					}
				}
			}
		}
		
		graph.reset();
		return results;
	}
	
	public void printPaths() {
		for(int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
	}
	
	
}
