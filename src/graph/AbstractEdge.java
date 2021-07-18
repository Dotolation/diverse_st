package graph;

public abstract class AbstractEdge<T> implements Comparable<AbstractEdge<T>> {
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("<%s, %s>", v1, v2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEdge<T> other = (AbstractEdge<T>) obj;
		if (v1 == null) {
			if (other.v1 != null)
				return false;
		} else if (!v1.equals(other.v1))
			return false;
		if (v2 == null) {
			if (other.v2 != null)
				return false;
		} else if (!v2.equals(other.v2))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(AbstractEdge<T> o) {
		// TODO Auto-generated method stub
		if(this.hashCode() == o.hashCode()) {
			return 0;
		} else if (this.hashCode() > o.hashCode()) {
			return 1;
		}
		
		return -1; 
	}

}
