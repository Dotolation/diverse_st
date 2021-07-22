package simplegraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//This is a directed graph. 
public class Graph {
	
	public List<Vertex> vertexList;
	
	public Vertex start;
	public Vertex end; 
	
	public Graph(ArrayList<Vertex> vertexList, Vertex start, Vertex end) {
		
		this.vertexList = vertexList;
		
		this.start = start;
		this.end = end;
	
	}
	
	public void vertexCost() {
		
		start.cost = 0;
		
		Queue<Vertex> vertexQueue = new ArrayDeque<>();
		vertexQueue.add(start);
		
		while(!vertexQueue.isEmpty()) {
			Vertex current = vertexQueue.poll();
			
			if (current.childArcs == null) continue;
			
			for(Arc arc : current.childArcs) {
				
				//Set the cost of the child vertex, 
				//which is the sum of cost of the current vertex + cost of the current arc.
				//Renew the cost only if the above sum is smaller than the cost previously set. 
				Vertex next = arc.to;
				if (next == null) continue; 
				
				int costSum = current.cost + arc.cost;
				next.cost = (next.cost == Integer.MIN_VALUE) ? costSum : Math.min(next.cost, costSum);
				
				vertexQueue.add(next);
				
			}
			
		}
		
	}

}
