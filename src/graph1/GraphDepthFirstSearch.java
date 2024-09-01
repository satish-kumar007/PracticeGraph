package graph1;

import java.util.*;

public class GraphDepthFirstSearch {

    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    public GraphDepthFirstSearch(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<Integer>();
            System.out.println(adjLists[i]);
        }
    }

    void addEdge(int src, int dest) {
        adjLists[src].add(dest);

        //Add below line in case of undirected graph.
        adjLists[dest].add(src);
    }

    public void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        System.out.println(adjLists[vertex]);
        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String args[]) {
        GraphDepthFirstSearch dfs = new GraphDepthFirstSearch(4);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal");
        dfs.DFS(2);
        System.out.println();
    }


}
