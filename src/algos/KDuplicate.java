package algos;

import java.util.ArrayList;

import graph.Arc;
import graph.DirectedGraph;

public class KDuplicate {
	
	private static <T> ArrayList<Arc<T>> kArcList (ArrayList<Arc<T>> arcList, int k){
		ArrayList<Arc<T>> newList = new ArrayList<>();
		
		for (Arc<T> arc : arcList) {
			
			for(int i = 1; i <= k; i++) {
				
				double newWeight = arc.weight * (k- 2*i + 1);
				newList.add(new Arc<>(arc.v1, arc.v2, newWeight));
				
			}
			
		}
		
		return newList;
	}
	
	public static <T> DirectedGraph<T> duplicate (DirectedGraph<T> g, int k){
		ArrayList<Arc<T>> arcList = kArcList((ArrayList<Arc<T>>) g.getEdgeList(), k);
		DirectedGraph<T> multigraph = new DirectedGraph<>(arcList); 
		
		return multigraph;
	}
}
