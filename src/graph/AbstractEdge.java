package graph;

public abstract class AbstractEdge<T> {
	
	public final T v1;
	public final T v2;
	
	public double weight;
	
	public AbstractEdge (T v1, T v2, double weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	public AbstractEdge (T v1, T v2) {
		this(v1, v2, 1.0);
	}

}
