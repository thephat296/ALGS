package Lab10.lesson10_graphs.graph;
import java.util.*;
/**
 * This simple subclass of DepthFirstSearch just tracks the vertices
 * DFS visits in the order in which they are visited.
 *
 */
public class DFSVisited extends DepthFirstSearch {
	public DFSVisited(Graph graph) {
		super(graph);
	}
	List<Vertex> visitedVertices = new ArrayList<>();
	public void processVertex(Vertex w) {
		visitedVertices.add(w);
	}
}
