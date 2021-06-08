package graph;

import java.util.LinkedList;

public class Path<T> {
	
	private LinkedList<Arc<T>> arcs; 
	private double length = 0; 

	public Path(Arc<T> arc) {
		arcs = new LinkedList<>();
		arcs.add(arc);
		length += arc.weight;	
	}
	
	public T getHead() {
		return arcs.getFirst().orig();
	}
	
	public T getTail() {
		return arcs.getLast().dest();
	}
	
	public void addArc(Arc<T> arc) {
		if(arc.orig().equals(getTail())) {
			arcs.addLast(arc);
			length += arc.weight;
		} else if (arc.dest().equals(getHead())) {
			arcs.addFirst(arc);
			length += arc.weight;
		} else {
			System.out.print("Adding failed.");
		}
	}

	public double getLength() {
		return length; 
	}
	
}
