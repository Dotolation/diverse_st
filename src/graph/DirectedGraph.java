package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DirectedGraph<T> extends AbstractGraph<T> {
	
	private HashMap<T, ArrayList<T>> parentMap;
	private HashMap<T, ArrayList<T>> childMap;
	
	private HashMap<T, ArrayList<Arc<T>>> divergenceMap;
	private HashMap<T, ArrayList<Arc<T>>> convergenceMap; 
	 
	
	public DirectedGraph (List<Arc<T>> arcs) {
		super(arcs);	
	}
	
	public DirectedGraph (HashSet<T> vertices, List<Arc<T>> arcs) {
		super(vertices, arcs);
	}
	
	@Override
	protected void appendEdges(List<? extends AbstractEdge<T>> el, int index) {
		List<Arc<T>> arcs = (List<Arc<T>>) el;
		super.appendEdges(arcs, index);
		updateParentChildMap(arcs, index);
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
	
	
	public ArrayList<T> getParents(T vertex) {
		return parentMap.get(vertex);
	}
	
	public ArrayList<T> getChildren(T vertex) {
		return childMap.get(vertex);
	}
	
	public ArrayList<Arc<T>> divulgingFrom (T vertex){
		return divergenceMap.get(vertex);
		
	}
	
	public ArrayList<Arc<T>> convergingTo (T vertex){
		return convergenceMap.get(vertex);
	}
	
	

}
