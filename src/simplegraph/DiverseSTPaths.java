package simplegraph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class DiverseSTPaths {
	
	
	
	/**
	 * Removes edges that do not form the shortest st-path, and duplicate each edge r times. 
	 * @param g
	 */
	public static void preliminary(Graph g) {
		
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
			
			/*Duplicate remaining arcs r times. 
			for(int j=0; j < end; j++) {
				
			} 
			*/
			
		}	
		
	}

}
