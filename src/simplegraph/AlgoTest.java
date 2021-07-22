package simplegraph;

import java.util.ArrayList;
import java.util.List;

public class AlgoTest {
	
	public static Graph gridGenerate(int x, int y) {
		
		List<Vertex> vertexGrid = new ArrayList<>();
		
		for(int i=0; i < x * y; i++) vertexGrid.add(new Vertex(String.format("X: %d, Y: %d", 1 + (i % x), 1 + (i / x))));
		
		
		for(int i=0; i < x * y; i++) {
			
			if (i == x * y -1) continue;
			
			vertexGrid.get(i).childArcs = new ArrayList<Arc>();
			List<Arc> arcList = vertexGrid.get(i).childArcs;
			
			//Add a neighbor to the right if vertex is not the last column of the x * y vertex grid
			if((i % x) < x - 1) arcList.add(new Arc(vertexGrid.get(i+1), 1, 1));
			
			//Add a neighbor to the below if vertex is not on the last row of the x * y vertex grid
			if(i < x * (y-1)) arcList.add(new Arc(vertexGrid.get(i+x), 1, 1));
			
		} 

		return new Graph(vertexGrid, vertexGrid.get(0), vertexGrid.get(vertexGrid.size() - 1), true);
	}
	
	
	public static void main (String[] args) {
		
		Graph g1 = gridGenerate(13,13);
		Graph g2 = gridGenerate(13,13);
		
		//DiverseSTPaths.removeNonStEdges(g1);
		
		DiverseSTPaths.kDuplication(g1, 4);
		DiverseSTPaths.kDuplication(g2, 4);
		

		//assert g1.equals(g2);
		
		System.out.println("All is good!");
		
		
	}

}
