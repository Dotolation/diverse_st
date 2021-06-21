package graph.unused;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import graph.AbstractEdge;
import graph.AbstractGraph;
import graph.Edge;

public class UndirectedGraph<T> extends AbstractGraph<T> {
	
	private HashMap<T, List<T>> neighborMap;
	private HashMap<T, List<Edge<T>>> edgeMap;
	
	public UndirectedGraph(HashSet<T> verticesSet, List<Edge<T>> edgeList) {
		super(verticesSet, edgeList);
	}
	
	public UndirectedGraph(List<Edge<T>> edgeList) {
		super(edgeList);
	}
	
	@Override
	protected void appendEdges(List<? extends AbstractEdge<T>> edgeList, int index) {
		try {
			List<Edge<T>> el = (List<Edge<T>>) edgeList;
			updateNeighborMap(el, index);
			updateEdgeMap(el, index);
			this.updateVerticesSet(edgeList, index);
		
		} catch (Exception e) {
		   System.out.println("Please check if the edges belong to the 'Edge' class.");
		}
		
	}
	
	private void updateNeighborMap(List<Edge<T>> el, int index) {
		Edge<T> edge = el.get(index);
		
		//v1
		neighborMap.putIfAbsent(edge.v1, new ArrayList<>());
		neighborMap.get(edge.v1).add(edge.v2);
		
		//v2
		neighborMap.putIfAbsent(edge.v2, new ArrayList<>());
		neighborMap.get(edge.v2).add(edge.v1);
		
	}
	
	private void updateEdgeMap(List<Edge<T>> el, int index) {
		Edge<T> edge = el.get(index);
		
		//v1
		edgeMap.putIfAbsent(edge.v1, new ArrayList<>());
		edgeMap.get(edge.v1).add(edge);
		
		//v2
		edgeMap.putIfAbsent(edge.v2, new ArrayList<>());
		edgeMap.get(edge.v2).add(edge);
		
	}
	
	public List<T> getNeighbors(T vertex){
		return neighborMap.get(vertex);
	}
	
	public List<Edge<T>> getConnectedEdges(T vertex){
		return edgeMap.get(vertex);
	}

}
