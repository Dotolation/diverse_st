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
		
		HashSet<Arc<String>> hmm = new HashSet<>();
		hmm.add(str1Clone);
		hmm.add(str1);
		hmm.add(new Arc<>("b","a"));
		
		assert hmm.size()==2 : "what's the size then?";
		
		
		
		
		

	}

}
