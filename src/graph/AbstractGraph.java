package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractGraph<T> {
	
	protected HashSet<T> verticesSet;
	protected List<? extends AbstractEdge<T>> edgeList;

	
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
	
	protected abstract void appendEdges(List<? extends AbstractEdge<T>> edgeList, int index);
	
	protected void updateVerticesSet(List<? extends AbstractEdge<T>> el, int index) {
		AbstractEdge<T> edge = el.get(index);
		verticesSet.add(edge.v1);
		verticesSet.add(edge.v2);
	}
	
	public List<? extends AbstractEdge<T>> getEdgeList(){
		return edgeList;
	}

}
