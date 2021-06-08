package algos;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import graph.Arc;
import graph.DirectedGraph;
import graph.Path;

public class STPathMany {
	
	public static <T> void Djikstra(DirectedGraph<T> g, T s, T t){
		
		Map<T, Path<T>> pathsToHere = new HashMap<>();
		Queue<T> verticesQueue = new ArrayDeque<>();
		
		verticesQueue.add(s);
		
		while(!verticesQueue.isEmpty()) {
			T current = verticesQueue.poll();
			
			//All arcs divulging from the current vertex.
			List<Arc<T>> childrenEdges = g.divulgingFrom(current);
			
			for(Arc<T> childEdge : childrenEdges) {
				T child = childEdge.dest();
				
				
				
			}
			
			
		}
		
		
	}

}
