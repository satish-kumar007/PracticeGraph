package graph1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class GraphDepthFirstSearch_1 {

    static void addEdge(List<List<Integer> > adj,int s, int t){
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    static void DFSRec(List<List<Integer> > adj,boolean[] visited, int source){
        // Mark the current vertex as visited
        visited[source] = true;
        System.out.print(source + " ");
        for (int i : adj.get(source)) {
            if (!visited[i]) {
                DFSRec(adj, visited, i);
            }
        }
    }

    static void DFS(List<List<Integer> > adj, int source) {
        boolean[] visited = new boolean[adj.size()];
        DFSRec(adj, visited, source);
    }

    public static void main(String[] args){
        int V = 5; // Number of vertices in the graph

        // Create an adjacency list for the graph
        List<List<Integer> > adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {{1,2}, {1,0}, {2,0}, {2,3}, {2,4}};

        // Populate the adjacency list with edges
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        int source = 1;
        System.out.println("DFS from source: " + source);
        DFS(adj, source);
    }
}
