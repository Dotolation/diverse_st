package algos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graph.Arc;
import graph.DirectedGraph;

public class STPathMany {
	
	public static <T> DirectedGraph<T> djikstra(DirectedGraph<T> g, T s, T t){
		
		//Parent vertices that forms shortest path from s to this vertex.
		Map<T, List<T>> bestParents = new HashMap<>();
		//shortest distance from s to this vertex.
		Map<T, Double> distanceRecord = new HashMap<>(); 
		
		Deque<T> verticesQueue = new ArrayDeque<>();
		
		verticesQueue.add(s);
		distanceRecord.put(s,0d);
		
		//Building bestParents and the distanceRecord 
		while(!verticesQueue.isEmpty()) {
			
			T current = verticesQueue.poll();
			//System.out.println(current);
			
			//All arcs divulging from the current vertex.
			List<Arc<T>> childrenArcs = g.divulgingFrom(current);
			if(childrenArcs==null) {
				continue;
			}
			
			//System.out.println(childrenArcs);
			
			for(Arc<T> childArc : childrenArcs) {
				
				T child = childArc.dest(); 
				
				//If the child node was never visited
				if(!bestParents.containsKey(child)) {
					
					AlgoUtil.newListValueInMap(bestParents, child, current);
					
					double distToChild = distanceRecord.get(current) + childArc.weight;
					distanceRecord.put(child, distToChild);
					
					verticesQueue.addLast(child);
					
				//The child node was visited before.	
				} else {
					
					double shortestLength = distanceRecord.get(child);
					double candidateLength = distanceRecord.get(current) + childArc.weight;
					
					if(candidateLength < shortestLength) {
						
						AlgoUtil.newListValueInMap(bestParents, child, current);
						distanceRecord.put(child, candidateLength);
						
						verticesQueue.addFirst(child);
						
					} else if (candidateLength == shortestLength) {
						AlgoUtil.appendToListValueInMap(bestParents, child, current);
					} else {
						//do nothing
					}
				}
				
			}
		}
			
			//System.out.println(bestParents);
			return buildPaths(bestParents, distanceRecord, t);
		
	}
	
	private static <T> DirectedGraph<T> buildPaths(Map<T, List<T>> bestParents, 
			Map<T, Double> distanceRecord, T t) {
		
		Deque<T> verticesQueue = new ArrayDeque<>();
		verticesQueue.add(t);
		
		Set<Arc<T>> edgeSet = new HashSet<>();
		
		while(!verticesQueue.isEmpty()) {
			
			T current = verticesQueue.pop();
			double dist = distanceRecord.get(current);
			
			if(bestParents.get(current) == null) {
				continue;
			}
			
			
			for(T parent : bestParents.get(current)) {
				
				double parentDist = distanceRecord.get(parent);
				Arc<T> arc = new Arc<>(parent, current, dist - parentDist);
				edgeSet.add(arc);
				
				verticesQueue.add(parent);
				
			}
		}
		
		return new DirectedGraph<T>(new ArrayList<Arc<T>>(edgeSet));
		
	}

}
