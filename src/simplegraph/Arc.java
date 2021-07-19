package simplegraph;

public class Arc implements Comparable<Arc> {
	
	public Vertex to; 
	
	public int capacity;
	public int cost;
	
	public Arc(Vertex to, int capacity, int cost) {
		this.to = to;
		this.capacity = capacity;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Arc o) {
		return cost - o.cost;
	}

}
