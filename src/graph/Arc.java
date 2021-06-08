package graph;

public class Arc<T> extends AbstractEdge<T> {
	
	public T orig() {
		return this.v1;
	}
	
	public T dest(){
		return this.v2;
	}
	
	public Arc (T v1, T v2, double weight) {
		super(v1, v2, weight);
	}
	
	public Arc (T v1, T v2) {
		super(v1, v2);
	}
}
