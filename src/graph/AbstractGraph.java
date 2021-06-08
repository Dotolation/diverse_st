package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractGraph<T> {
	
	protected HashSet<T> verticesSet;
	protected List<? extends AbstractEdge<T>> edgeList;
	protected HashMap<T, ArrayList<T>> neighborMap;
	protected HashMap<T, ArrayList<AbstractEdge<T>>> edgeMap; 
	
	
	
	public AbstractGraph(HashSet<T> verticesSet, List<? extends AbstractEdge<T>> edgeList) {
		this.verticesSet = verticesSet;
		this.edgeList = edgeList;
		
		for(int i = 0; i < edgeList.size(); i++) {
			appendEdges(edgeList, i);
		}	
	}
	
	public AbstractGraph(List<? extends AbstractEdge<T>> edgeList) {
		this(new HashSet<T>(), edgeList);
	}
	
	protected void appendEdges(List<? extends AbstractEdge<T>> el, int index) {
		updateNeighborMap(el, index);
		updateEdgeMap(el, index);
		updateVerticesSet(el, index);
	}
	
	private void updateNeighborMap(List<? extends AbstractEdge<T>> el, int index) {
		AbstractEdge<T> edge = el.get(index);
		
		//v1
		neighborMap.putIfAbsent(edge.v1, new ArrayList<>());
		neighborMap.get(edge.v1).add(edge.v2);
		
		//v2
		neighborMap.putIfAbsent(edge.v2, new ArrayList<>());
		neighborMap.get(edge.v2).add(edge.v1);
		
	}
	
	private void updateEdgeMap(List<? extends AbstractEdge<T>> el, int index) {
		AbstractEdge<T> edge = el.get(index);
		
		//v1
		edgeMap.putIfAbsent(edge.v1, new ArrayList<>());
		edgeMap.get(edge.v1).add(edge);
		
		//v2
		edgeMap.putIfAbsent(edge.v2, new ArrayList<>());
		edgeMap.get(edge.v2).add(edge);
		
	}
	
	private void updateVerticesSet(List<? extends AbstractEdge<T>> el, int index) {
		AbstractEdge<T> edge = el.get(index);
		verticesSet.add(edge.v1);
		verticesSet.add(edge.v2);
	}
	
	public ArrayList<T> getNeighbors(T vertex){
		return neighborMap.get(vertex);
	}
	
	public ArrayList<? extends AbstractEdge<T>> getConnectedEdges(T vertex){
		return edgeMap.get(vertex);
	}

	
}
