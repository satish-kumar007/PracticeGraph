package graph1;

public class CreateGraphArrayAdjacencyUndirected {
    private boolean[][] adjacencyMatrix;
    private int numVertices;
    public CreateGraphArrayAdjacencyUndirected(int numVertices){
        this.numVertices = numVertices;
        adjacencyMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int i, int j){
        adjacencyMatrix[i][j] = true;
        adjacencyMatrix[j][i] = true;
    }

    public void printGraph(){
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void removeEdge(int i, int j){
        adjacencyMatrix[i][j] = false;
        adjacencyMatrix[j][i] = false;
    }

    public boolean hasEdge(int i, int j){
        return adjacencyMatrix[i][j];
    }

    public static void main(String[] args) {
        CreateGraphArrayAdjacencyUndirected graph = new CreateGraphArrayAdjacencyUndirected(8);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(3, 5);
        graph.addEdge(4,2);
        graph.addEdge(1,2);
        graph.addEdge(2,5);
        graph.addEdge(5,6);
        System.out.println("Graph Representation (Adjacency Matrix):");
        graph.printGraph();
    }
}
