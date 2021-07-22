package simplegraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;



public class DiverseSTPaths {
	
	/**
	 * Removes edges that do not form the shortest st-path.
	 * @param g
	 */
	public static void removeNonStEdges(Graph g) {
		
		g.vertexCost();
		
		Queue<Vertex> vertexQueue = new ArrayDeque<>();
		vertexQueue.add(g.start);
		
		while (!vertexQueue.isEmpty()) {
			
			Vertex current = vertexQueue.poll();
			List<Arc> childArcs = current.childArcs;
			
			if (childArcs==null) continue;
			
			
			//arc removal loop.
			int i = 0;
			int end = childArcs.size();
			
			while(i < end){
				Arc arc = childArcs.get(i);
				Vertex next = arc.to;
				
				if(next != null) vertexQueue.add(next); //add the next node to vertexQueue.
				
				/* remove the arc if it cannot be part of the shortest ST Path.
				   That is, if the arc does not form the shortest path to the 'next' node. */
				if(next.cost < arc.cost + current.cost) {
					childArcs.remove(i--);
					end--;
				}
				
				i++;

			}
			
		}	
		
	}
	
	/**
	 * Removes edges that do not form the shortest st-path.
	 * @param g
	 */
	public static void kDuplication (Graph g, int k){
		
		for (Vertex v : g.vertexList) {
			
			if (v.childArcs == null) continue;
			
			List<Arc> rCopies = new ArrayList<>();
			//k-duplication
			for(Arc arc : v.childArcs) {	
				for(int i=1; i<=k; i++) {
					int newCost = arc.cost * (k - 2*i + 1);
					rCopies.add(new Arc(arc.to, arc.capacity, newCost));
				} 
			}
			
			v.childArcs = rCopies; //replace the edges with the duplicates. 	

		}
	}

}
