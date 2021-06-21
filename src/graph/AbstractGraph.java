package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractGraph<T> {
	
	protected HashSet<T> verticesSet;
	protected ArrayList<? extends AbstractEdge<T>> edgeList;

	
	
	/**
	 * Creates a graph from the edges and vertices.
	 * Use this constructor if any orphan vertices need to be included.
	 * 
	 * @param a HashSet of the vertices.
	 * @param an Arraylist of the edges. 
	 */
	public AbstractGraph(HashSet<T> verticesSet, ArrayList<? extends AbstractEdge<T>> edgeList) {
		this.verticesSet = verticesSet;
		this.edgeList = edgeList;
		
		for(int i = 0; i < edgeList.size(); i++) {
			appendEdges(edgeList, i);
		}	
	}
	
	
	/**
	 * Create a graph just from the edges. 
	 * 
	 * @param an Arraylist of the edges that form the graph.
	 */
	public AbstractGraph(ArrayList<? extends AbstractEdge<T>> edgeList) {
		this(new HashSet<T>(), edgeList);
	}
	
	protected abstract void appendEdges(ArrayList<? extends AbstractEdge<T>> edgeList, int index);
	
	protected void updateVerticesSet(ArrayList<? extends AbstractEdge<T>> el, int index) {
		AbstractEdge<T> edge = el.get(index);
		verticesSet.add(edge.v1);
		verticesSet.add(edge.v2);
	}
	
	
	/**
	 * Gives all the edges in the graph.
	 * @return an ArrayList of all the edges in the graph.
	 */
	public List<? extends AbstractEdge<T>> getEdgeList(){
		return edgeList;
	}

}
