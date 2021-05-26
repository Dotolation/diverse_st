package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	
	public HashSet<Vertex> v = new HashSet<Vertex>();
	public List<Edge> e;

	public Graph(HashSet<Vertex> v, List<Edge> e) {
		this.v = v;
		this.e = e;
	}
	
	public Graph(List<Edge> e) {
		this.e = e;
		for (Edge edge : e ) {
			//v.addAll(edge.getVertices());
		}
	}
	
	
}
