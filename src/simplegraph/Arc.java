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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arc other = (Arc) obj;
		if (capacity != other.capacity)
			return false;
		if (cost != other.cost)
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}


	
	

}
