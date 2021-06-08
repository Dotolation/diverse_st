package graph;

import java.util.Arrays;
import java.util.HashSet;

public class Edge<T> extends AbstractEdge<T>{
	
	public final HashSet<T> vertices;
	
	public Edge (T v1, T v2, double weight) {
		super(v1, v2, weight);
		vertices = new HashSet<>(Arrays.asList(v1,v2));
	}
	
	public Edge (T v1, T v2) {
		this(v1, v2, 1.0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertices == null) ? 0 : vertices.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge<T> other = (Edge<T>) obj;
		if (vertices == null) {
			if (other.vertices != null)
				return false;
		} else if (!vertices.equals(other.vertices))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
	
}
