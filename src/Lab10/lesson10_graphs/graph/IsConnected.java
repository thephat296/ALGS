package Lab10.lesson10_graphs.graph;

public class IsConnected extends DepthFirstSearch {
	private int numComponents = 0;
	public IsConnected(Graph graph) {
		super(graph);
	}

	@Override
	public void additionalProcessing() {
		numComponents++;
	}

	public boolean isConnected() {
		start();
		return numComponents == 1;
	}
}
