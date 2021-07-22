package simplegraph;

import java.util.List;

public class Vertex {
	
	String node; //for debugging (toString())
	
	List<Arc> childArcs;
	int cost = Integer.MIN_VALUE;
	
	//for minimum-cost flow
	Arc before; 

	public Vertex() {}
	
	public Vertex(String node) {
		this.node = node ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (before == null) {
			if (other.before != null)
				return false;
		} else if (!before.equals(other.before))
			return false;
		if (childArcs == null) {
			if (other.childArcs != null)
				return false;
		} else if (!childArcs.equals(other.childArcs))
			return false;
		if (cost != other.cost)
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		
		return buildString().toString();
		
	}
	
	protected StringBuilder buildString() {
		
		StringBuilder sb = new StringBuilder(String.format("<%s>(%d)", node, cost));
		
		sb.append("{");
		
		if(childArcs != null) {
			
			for(Arc arc : childArcs) {
				sb.append(String.format("[cost:%d][cap:%d]", arc.cost, arc.capacity));
				sb.append(arc.to.buildString());
			}
			
		}
		
		sb.append("}");
		
		return sb; 
	}
	
	

}
