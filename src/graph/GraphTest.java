package graph;

import java.util.HashSet;

public class GraphTest {
	
	

	public static void main(String[] args) {
		
		//Testing Arcs: Should not be equal when the orientation is reversed.
		Arc<String> str1 = new Arc<>("a", "b");
		Arc<Integer> int1 = new Arc<>(5, 7);
		
		assert !str1.equals(str1.oppositeArc());
		assert str1.equals(str1.oppositeArc().oppositeArc());
		
		assert !int1.equals(int1.oppositeArc());
		assert int1.equals(int1.oppositeArc().oppositeArc());
		
		//Testing Arcs: Identical arcs should have same hashcode.
		Arc<String> str1Clone = new Arc<>("a", "b");
		Arc<Integer> int1Clone = new Arc<>(5, 7);
		
		assert str1.hashCode()==str1Clone.hashCode() : "hashCode Not Equal";
		assert int1.hashCode()==int1Clone.hashCode() : "Hashcode not equal (int)";
		
		HashSet<Arc<String>> strArcSet = new HashSet<>();
		strArcSet.add(str1Clone);
		strArcSet.add(str1);
		strArcSet.add(str1.oppositeArc());
		
		assert strArcSet.size()==2;
		
		//Testing Arcs: String test
		System.out.println(int1.toString());
		System.out.println(String.valueOf(int1.oppositeArc()));
		
		
		
		
		//Testing Directed Graph
		
		DirectedGraph<String> graph1 = new DirectedGraph<>(
										   new Arc<>("a", "b"),
										   new Arc<>("b", "c"),
										   new Arc<>("c", "d"),
										   new Arc<>("c", "e"),
										   new Arc<>("b", "f"),
										   new Arc<>("b", "i"),
										   new Arc<>("i", "j"),
										   new Arc<>("j", "c"));
		
		System.out.println(graph1);
		System.out.println(graph1.getParents("c"));
		System.out.println(graph1.convergingTo("c"));
		System.out.println(graph1.getChildren("b"));
		System.out.println(graph1.divulgingFrom("b"));
		
		
		

	}

}
