package powerGrid;

import java.util.*;

import GraphTheory.AdjacencyList;
import GraphTheory.Vertex;
public class GraphTraverser {
	private ArrayList<Path> results;
	
	public GraphTraverser() {
		results = new ArrayList<Path>();
	}
	
	public ArrayList<Path> traverse(DataStructure<Path> ds, AdjacencyList graph, String startName){
		Path a = new Path(graph.getVertex(startName));
		ds.add(a);
		while(ds.isEmpty() == false) {
			Path b = ds.remove();
			Vertex e = b.getLastVertex();
			if(e.getVisited() == false) {
				e.setVisited(true);
				results.add(b);
				for(Vertex c : e.allNeighbors()) {
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
	
	public void printEdges() {
		EdgeList e = new EdgeList();
		int length = 0;
		for(Path p : results) {
			if(p.getNumVertexes() > 1) {
				e.addEdge(new Edge(p.getVertex(p.getNumVertexes() - 2), p.getLastVertex(), p.getLastEdgeWeight()));
				length += p.getLastEdgeWeight();
			}
		}
		System.out.println(e);
		System.out.println("Total: " + length);
	}
}
