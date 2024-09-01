package graph1;

public class CreateGraphArrayAdjacencyDirected {
    int[][] adjacencyMatrixDirected;
    int edges;

    public CreateGraphArrayAdjacencyDirected(int edges){
        this.edges = edges;
        adjacencyMatrixDirected = new int[edges][edges];
    }

    public void addEdges(int source, int destination){
        adjacencyMatrixDirected[source][destination] = 1;
    }

    public void printAdjacencyMatrix(){
        for(int i=0;i<edges;i++){
            for(int j=0;j<edges;j++){
                System.out.print(adjacencyMatrixDirected[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void removeEdge(int source, int destination) {
        adjacencyMatrixDirected[source][destination] = 0;
    }

    public boolean hasEdge(int source, int destination) {
        return adjacencyMatrixDirected[source][destination] == 1;
    }

    public static void main(String[] args) {
        CreateGraphArrayAdjacencyDirected graph = new CreateGraphArrayAdjacencyDirected(8);
        graph.addEdges(1, 3);
        graph.addEdges(3, 4);
        graph.addEdges(4, 6);
        graph.addEdges(3, 5);
        graph.addEdges(4,2);
        graph.addEdges(1,2);
        graph.addEdges(2,5);
        graph.addEdges(5,6);
        System.out.println("Graph Representation (Adjacency Matrix):");
        graph.printAdjacencyMatrix();
    }
}
