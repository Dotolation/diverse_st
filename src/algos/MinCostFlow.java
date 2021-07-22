package algos;
import java.util.*;

public class MinCostFlow {
	static final int INF = Integer.MAX_VALUE;
	int n;
	V[] vs;
	V s, t;
	MinCostFlow(int n) {
		vs = new V[n];
		for (int i = 0; i < n; i++)
			vs[i] = new V();
	}
	void make(int from, int to, int cap, int cost) {
		E e = new E(vs[to], cap, cost);
		E r = new E(vs[from], 0, -cost);
		e.rev = r;
		r.rev = e;
		vs[from].es.add(e);
		vs[to].es.add(r);
	}
	
	
	int minCostFlow(int from,int to,int flow) {
		s = vs[from];
		t = vs[to];
		int cost = 0;
		while (flow > 0) {
			for (V v : vs) v.cost = INF;
			Queue<E> q = new PriorityQueue<E>();
			s.cost = 0;
			s.bef = null;
			t.bef = null;
			q.offer(new E(s, 0, 0));
			while (!q.isEmpty()) {
				V v = q.poll().to;
				for (E e : v.es) {
					if (e.cap > 0 && e.to.cost > e.cost + v.cost) {
						e.to.cost = e.cost + v.cost;
						e.to.bef = e;
						q.offer(e);
					}
				}
			}

			if (t.bef == null) return -1;
			int min = flow;
			for (E e = t.bef; e != null; e = e.rev.to.bef) {
				min = Math.min(min, e.cap);
			}
			for (E e = t.bef; e != null; e = e.rev.to.bef) {
				e.cap -= min;
				cost += e.cost * min;
				e.rev.cap += min;
			}
			flow -= min;
		}
		return cost;
	}
	class V {
		ArrayList<E> es = new ArrayList<E>();
		E bef;
		int cost;
	}
	class E implements Comparable<E> {
		E rev;
		V to;
		int cap;
		int cost;
		E(V to, int cap, int cost) {
			this.to = to;
			this.cap = cap;
			this.cost = cost;
		}
		public int compareTo(E o) {
			return cost - o.cost;
		}
	}
}