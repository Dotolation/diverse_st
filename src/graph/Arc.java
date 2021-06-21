package graph;

public class Arc<T> extends AbstractEdge<T> {
	
	
	/**
	 * Returns the origin (parent) vertex of the arc.
	 * @return the parent vertex of a generic type <T>
	 */
	public T orig() {
		return this.v1;
	}
	
	/**
	 * Returns the destination (child) vertex of the arc.
	 * @return the child vertex of a generic type <T>
	 */
	public T dest(){
		return this.v2;
	}
	
	public Arc (T v1, T v2, double weight) {
		super(v1, v2, weight);
	}
	
	public Arc (T v1, T v2) {
		super(v1, v2);
	}
	
	public Arc<T> oppositeArc(){
		return new Arc<>(v2, v1, weight);
	}
}
