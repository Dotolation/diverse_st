package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FlowNetwork<T> extends DirectedGraph<T> {
	
	public T source;
	public T sink; 

	public FlowNetwork (T source, T sink, HashSet<T> vertices, List<Arc<T>> arcs) {
		super(vertices, arcs);
		this.source = source;
		this.sink = sink;
	}
	
	public FlowNetwork (T source, T sink, List<Arc<T>> arcs) {
		this(source, sink, new HashSet<>(), arcs);	
	}
	
	public FlowNetwork (T source, T sink, Arc<T>...arcs) {
		this(source, sink, Arrays.asList(arcs));
	}

}
