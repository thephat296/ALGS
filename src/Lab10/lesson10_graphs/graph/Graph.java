package Lab10.lesson10_graphs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class Graph {
	private LinkedList<Vertex> vertices = new LinkedList<Vertex>();
	private LinkedList<Edge> edges = new LinkedList<Edge>();
	HashMap<Vertex,LinkedList<Vertex>> adjList = new HashMap<Vertex,LinkedList<Vertex>>();

	////public operations
	public Graph computeSpanningTree() {
		FindSpanningTree fst = new FindSpanningTree(this);
		return fst.computeSpanningTree();
	}

	public boolean pathExists(Vertex u, Vertex v) {
		PathExists pe = new PathExists(this);
		return pe.pathExists(u, v);
	}

	public boolean isConnected() {
		IsConnected ic = new IsConnected(this);
		return ic.isConnected();
	}

	public boolean hasCycle() {
		HasCycle hc = new HasCycle(this);
		return hc.hasCycle();
	}

	/**
	 * Constructs a graph from a list of pairs. A pair (A,B)
	 * is transformed into vertices A and B together with an edge A-B.
	 */
	public Graph(List<Pair> pairs){
		HashMap<Vertex,Vertex> dupverts = new HashMap<Vertex,Vertex>();
		HashMap<Edge,Edge> dupedges = new HashMap<Edge,Edge>();
		for(Pair e : pairs){
			//handle the vertices and edges simultaneously
			Vertex v1 = new Vertex(e.ob1);
			Vertex v2 = new Vertex(e.ob2);
			Edge edge = new Edge(v1,v2);
			if(!dupverts.containsKey(v1)){
				dupverts.put(v1,v1);
				vertices.add(v1);
			}
			if(!dupverts.containsKey(v2)){
				dupverts.put(v2,v2);
				vertices.add(v2);
			}

			if(!dupedges.containsKey(edge)){
				dupedges.put(edge,edge);
				edges.add(edge);
			}

			LinkedList<Vertex> l = adjList.get(v1);
			if(l == null) {
				l = new LinkedList<Vertex>();
			}
			l.add(v2);
			adjList.put(v1,l);

			LinkedList<Vertex> l2 = adjList.get(v2);
			if(l2 == null) {
				l2 = new LinkedList<Vertex>();
			}
			l2.add(v1);
			adjList.put(v2,l2);
		}

	}
	/**
	 * Constructs a Graph object from an array of Edges. Used internally to create
	 * a spanning tree or a set of connected components.
	 */
	public Graph(Edge[] inputEdges) {
		HashMap<Vertex,Vertex> dupverts = new HashMap<Vertex,Vertex>();

		for(Object ob: inputEdges) {
			if(ob.getClass() != Edge.class) continue;
			Edge e = (Edge)ob;
			//Assume dup edges are not allowed
			edges.add(e);
			Vertex v1 = e.u;
			Vertex v2 = e.v;
			if(!dupverts.containsKey(v1)){
				dupverts.put(v1,v1);
				vertices.add(v1);
			}

			if(!dupverts.containsKey(v2)){
				dupverts.put(v2,v2);
				vertices.add(v2);

			}

			LinkedList<Vertex> l = adjList.get(v1);
			if(l == null) {
				l = new LinkedList<Vertex>();
			}
			l.add(v2);
			adjList.put(v1,l);

			LinkedList<Vertex> l2 = adjList.get(v2);
			if(l2 == null) {
				l2 = new LinkedList<Vertex>();
			}
			l2.add(v1);
			adjList.put(v2,l2);
		}
	}

	public boolean areAdjacent(Vertex v, Vertex w) {
		LinkedList<Vertex> l = adjList.get(v);
		if(l == null) return false;
		return l.contains(w);
	}
	/**
	 * Important to return only a copy of the adjacency list. Running time for making
	 * this copy: For each vertex v, the number of adjacent vertices to v that need to
	 * be copied into a new list (matched with v in the copy of the map) is deg v. Also, each
	 * vertex is processed (cloned and the clone is added to its list); processing is O(1) Therefore,
	 * it is the sum over v in V of 1 + deg(v), which is O(n+m).
	 */
	public HashMap<Vertex,LinkedList<Vertex>> getAdjacencyList() {
		HashMap<Vertex,LinkedList<Vertex>> copy = new HashMap<Vertex,LinkedList<Vertex>>();
		for(Vertex v : adjList.keySet()) {
			copy.put(v, getListOfAdjacentVerts(v));
		}
		return copy;
	}
	/**
	 * Returns a copy of the list of adjacent vertices
	 */
	public LinkedList<Vertex> getListOfAdjacentVerts(Vertex v) {
		List<Vertex> theList = adjList.get(v);
		LinkedList<Vertex> copy = new LinkedList<Vertex>();
		if (theList != null) {
			for(Vertex vert : theList) {
				copy.add(vert.clone());
			}
		}
		return copy;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("Vertices: \n"+" ");
		for(Vertex v : vertices) {
			sb.append(v+" ");
		}
		sb.append("\nEdges:\n"+" ");
		HashMap<String,String> dups = new HashMap<String,String>();
		for(Vertex v: vertices){
			LinkedList<Vertex> l  = adjList.get(v);

			for(Vertex w : l){
				String edge = v.toString()+"-"+w.toString();
				String edgeRev = reverse(edge);
				if(!dups.containsKey(edge) && !dups.containsKey(edgeRev)){
					sb.append(edge+" ");
					dups.put(edge,edge);
				}
			}
		}
		return sb.toString();
	}
	private String reverse(String edge) {
		String[] vals = edge.split("-");
		return vals[1]+"-"+vals[0];
	}
	
	/**  
	 * This is a recursive version of dfs. The call stack is
	 * used to mimic the use of an external stack that is used
	 * in the DFS class. For binary trees, this is the same
	 * as preorder traversal. 
	 */
	List<Vertex> visitedVerts = new ArrayList<>();
	public void dfs_rec(Vertex v) {
		visitedVerts.add(v);
		List<Vertex> list = adjList.get(v);
		for(int i = 0; i < list.size(); ++i) {
			Vertex w = list.get(i);
			if(!visitedVerts.contains(w)) {
				dfs_rec(w);
			}
		}	
	}
	
	List<Edge> treeEdges = new ArrayList<>();
	List<Vertex> visitedVerts2 = new ArrayList<>();
	/**
	 * Uses recursive dfs to output the edges of 
	 * a spanning tree for this graph.
	 * 
	 * @param v - the start vertex for dfs
	 * @see dfs_rec
	 */
	public void dfs_rec_tree(Vertex v) {
		//implement
		visitedVerts2.add(v);
		List<Vertex> adjVertices = adjList.get(v);
		for (Vertex vertex : adjVertices) {
			if (!visitedVerts2.contains(vertex)) {
				treeEdges.add(new Edge(v, vertex));
				dfs_rec_tree(vertex);
			}
		}
	}
	
	/**
	 * Determines whether there is a path from v to u
	 * without using any auxiliary space (all variables are local)
	 */
	public static boolean dfs_rec_pathexists(Graph g, Vertex v, Vertex u, List<Vertex> visited) {
		//implement
		if (v.equals(u)) {
			return true;
		}
		visited.add(v);
		List<Vertex> adjVertices = g.adjList.get(v);
		for (Vertex w : adjVertices) {
			if (!visited.contains(w)) {
				return dfs_rec_pathexists(g, w, u, visited);
			}
		}
		return false;
	}
	
	
	/* Simply runs dfs to see order in which vertices are visited.
	 * Compare with dfs_rec.
	 */
	public void dfs(Vertex v) {
		DFSVisited dfsv = new DFSVisited(this);
		dfsv.start(v);
		System.out.println(dfsv.visitedVertices);
	}
	public List<Vertex> vertices() {
		return vertices;
	}

	public List<Edge> edges() {
		return edges;
	}

	public static void main(String[] args) {
		List<Pair> l = new ArrayList<Pair>();
		l.add(new Pair("A","B"));
		l.add(new Pair("B","C"));
		l.add(new Pair("A","C"));
		l.add(new Pair("A","E"));
		l.add(new Pair("C","D"));
		l.add(new Pair("D","E"));
		l.add(new Pair("F","E"));
		l.add(new Pair("E","A"));
		l.add(new Pair("F","G"));
		l.add(new Pair("G","H"));
		l.add(new Pair("H","F"));
		l.add(new Pair("K","L"));
		l.add(new Pair("L","M"));
		l.add(new Pair("M","K"));
		

//		Graph g = new Graph(l);
//		System.out.println(g);
//
//		Graph t = g.computeSpanningTree();
//		System.out.println("Spanning Tree\n" + t);
//
//		boolean found1 = g.pathExists(new Vertex("A"), new Vertex("F"));
//		boolean found2 = g.pathExists(new Vertex("A"), new Vertex("C"));
//		System.out.println(found1);
//		System.out.println(found2);
//
//		boolean isConnected = g.isConnected();
//		System.out.println(isConnected);
//
//		boolean hasCycle = g.hasCycle();
//		System.out.println(hasCycle);
//
//		Graph gr = new Graph(l);
//		System.out.println(gr);
//		gr.dfs_rec(new Vertex("A"));
//		System.out.println(gr.visitedVerts);
//		gr.dfs(new Vertex("A"));
		
//		Graph g = new Graph(l);
//		Graph t = g.computeSpanningTree();
//		System.out.println(t);
//		
//		g = new Graph(l);
//		g.dfs_rec_tree(new Vertex("A"));
//		System.out.println(g.visitedVerts2);
//		System.out.println(g.treeEdges);
		
		
		
	}
}
