package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import graph.Arc;
import graph.DirectedGraph;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Arc<Integer>> edgeList = Arrays.asList(new Arc<Integer>(1,2), new Arc<Integer>(3,4));
		List<Arc> edgeList2 = Arrays.asList(new Arc(1,2), new Arc(3,4));
		
		
		DirectedGraph<Integer> testGraph = new DirectedGraph<>(edgeList);
		
		//BellmanFord.bellmanFordMany(testGraph, 1, 2);

	}

}
