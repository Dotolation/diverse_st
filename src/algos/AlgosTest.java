package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import graph.AbstractEdge;
import graph.Arc;
import graph.DirectedGraph;

public class AlgosTest {
	
	public static DirectedGraph<String> gridGraph(int x, int y){
		String[][] vertexArray = new String [x][y];
		List<Arc<String>> arcList = new ArrayList<>();
		
		for (int i=0; i < x; i++) {
			String xName = "X:" + Integer.toString(i+1) + "  "; 
			for(int j=0 ; j < y; j++) {
				String yName = "Y:" + Integer.toString(j+1);
				vertexArray[i][j] = xName + yName;
				
				if(i>0) {
					arcList.add(new Arc<>(vertexArray[i-1][j], vertexArray[i][j]));
				}
				
				if(j>0) {
					arcList.add(new Arc<>(vertexArray[i][j-1], vertexArray[i][j]));
				}
			}
		}
		
		return new DirectedGraph<String>(arcList);
		
	}
	
	//Includes Diagonals. 
	public static DirectedGraph<String> gridGraph2(int x, int y){
		String[][] vertexArray = new String [x][y];
		List<Arc<String>> arcList = new ArrayList<>();
		
		for (int i=0; i < x; i++) {
			String xName = "X:" + Integer.toString(i+1) + "  "; 
			for(int j=0 ; j < y; j++) {
				String yName = "Y:" + Integer.toString(j+1);
				vertexArray[i][j] = xName + yName;
				
				if(i>0) {
					arcList.add(new Arc<>(vertexArray[i-1][j], vertexArray[i][j]));
				}
				
				if(j>0) {
					arcList.add(new Arc<>(vertexArray[i][j-1], vertexArray[i][j]));
				}
				
				if(i > 0 && j >0) {
					arcList.add(new Arc<>(vertexArray[i-1][j-1], vertexArray[i][j], Math.sqrt(1+1)));
				}
			}
		}
		
		return new DirectedGraph<String>(arcList);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DirectedGraph<String> grid = gridGraph(12,12);
		DirectedGraph<String> grid2 = STPathMany.djikstra(grid, "X:1  Y:1", "X:12  Y:12"); 
		
		assert grid.equals(grid2);
		
		DirectedGraph<String> gridDiag = gridGraph2(8,15);
		DirectedGraph<String> gridDiag2 = STPathMany.djikstra(gridDiag, "X:1  Y:1", "X:8  Y:15");
		
		System.out.println(gridDiag2);
		
		
		//BellmanFord.bellmanFordMany(testGraph, 1, 2);

	}

}
