package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DirectedGraph<T> extends AbstractGraph<T> {
	
	private HashMap<T, List<T>> parentMap;
	private HashMap<T, List<T>> childMap;
	
	private HashMap<T, List<Arc<T>>> divergenceMap;
	private HashMap<T, List<Arc<T>>> convergenceMap; 
	 
	/**
	 * Create a directed graph from the arcs. 
	 * 
	 * @param an List of the arcs that form the directed graph.
	 */
	public DirectedGraph (List<Arc<T>> arcs) {
		this(new HashSet<>(), arcs);	
	}
	
	/**
	 * Create a directed graph from the arcs and orphan vertices not connected by any edges. 
	 * 
	 * @param an List of the arcs that form the directed graph.
	 * @param a Hashset of orphan vertices.
	 */
	public DirectedGraph (HashSet<T> vertices, List<Arc<T>> arcs) {
		super(vertices, arcs);
		parentMap = new HashMap<>();
		childMap = new HashMap<>();
		divergenceMap = new HashMap<>();
		convergenceMap = new HashMap<>();
		
		for(int i = 0; i < edgeList.size(); i++) {
			appendEdges(edgeList, i);
		}
	}
	
	public DirectedGraph (Arc<T>...arcs) {
		this(Arrays.asList(arcs));
	}
	
	@Override
	protected void appendEdges(List<? extends AbstractEdge<T>> el, int index) {
		try {
			
			List<Arc<T>> arcs = (List<Arc<T>>) el;
			this.updateVerticesSet(el, index);
			updateParentChildMap(arcs, index);
			
		} catch (Exception e) {
		   System.out.println(e);
		}
	}
	
	private void updateParentChildMap(List<Arc<T>> el, int index) {
		Arc<T> edge = (Arc<T>) el.get(index);
		T p = edge.orig();
		T c = edge.dest();
		
		//v1 (Parent)
		childMap.putIfAbsent(p, new ArrayList<>());
		childMap.get(p).add(c);
		
		divergenceMap.putIfAbsent(p, new ArrayList<>());
		divergenceMap.get(p).add(edge);
		
		//v2
		parentMap.putIfAbsent(c, new ArrayList<>());
		parentMap.get(c).add(p);
		
		convergenceMap.putIfAbsent(c, new ArrayList<>());
		convergenceMap.get(c).add(edge);
		
	}
	
	
	/**
	 * 
	 * Given a vertex, find all of its parent vertices.  
	 * 
	 * @param a Vertex
	 * @return an List of the parent vertices
	 */
	public List<T> getParents(T vertex) {
		return parentMap.get(vertex);
	}
	
	/**
	 * 
	 * Given a vertex, find all of its parent vertices.  
	 * 
	 * @param a Vertex
	 * @return an List of the vertices
	 */
	public List<T> getChildren(T vertex) {
		return childMap.get(vertex);
	}
	
	public List<Arc<T>> divulgingFrom (T vertex){
		return divergenceMap.get(vertex);
		
	}
	
	public List<Arc<T>> convergingTo (T vertex){
		return convergenceMap.get(vertex);
	}
	
	

}
