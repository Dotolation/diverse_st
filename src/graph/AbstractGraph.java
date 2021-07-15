package graph;

import java.util.HashSet;
import java.util.List;

public abstract class AbstractGraph<T> {
	
	protected HashSet<T> verticesSet;
	protected List<? extends AbstractEdge<T>> edgeList;

	
	
	/**
	 * Creates a graph from the edges and vertices.
	 * Use this constructor if any orphan vertices need to be included.
	 * 
	 * @param a HashSet of the vertices.
	 * @param an List of the edges. 
	 */
	public AbstractGraph(HashSet<T> verticesSet, List<? extends AbstractEdge<T>> edgeList) {
		this.verticesSet = verticesSet;
		this.edgeList = edgeList;	
	}
	
	
	/**
	 * Create a graph just from the edges. 
	 * 
	 * @param an List of the edges that form the graph.
	 */
	public AbstractGraph(List<? extends AbstractEdge<T>> edgeList) {
		this(new HashSet<T>(), edgeList);
	}
	
	protected abstract void appendEdges(List<? extends AbstractEdge<T>> edgeList, int index);
	
	protected void updateVerticesSet(List<? extends AbstractEdge<T>> el, int index) {
		AbstractEdge<T> edge = el.get(index);
		verticesSet.add(edge.v1);
		verticesSet.add(edge.v2);
	}
	
	
	/**
	 * Gives all the edges in the graph.
	 * @return an List of all the edges in the graph.
	 */
	public List<? extends AbstractEdge<T>> getEdgeList(){
		return edgeList;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i=0; i<edgeList.size() ;i++) {
			buffer.append(edgeList.get(i));
			buffer.append("\n");
		}
		return buffer.toString();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractGraph<T> other = (AbstractGraph<T>) obj;
		if (edgeList == null) {
			if (other.edgeList != null)
				return false;
		} else if (!edgeList.equals(other.edgeList))
			return false;
		if (verticesSet == null) {
			if (other.verticesSet != null)
				return false;
		} else if (!verticesSet.equals(other.verticesSet))
			return false;
		return true;
	}
}
