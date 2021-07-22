package simplegraph;

import java.util.ArrayList;
import java.util.List;

public class AlgoTest {
	
	public static Graph gridGenerate(int x, int y) {
		
		List<Vertex> vertexList = new ArrayList<>();
		
		for(int i=0; i < x * y; i++) vertexList.add(new Vertex());
		
		

		return new Graph(vertexList, vertexList.get(0), vertexList.get(vertexList.size() - 1));
	}

}
