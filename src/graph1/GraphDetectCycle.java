package graph1;

import java.util.ArrayList;

public class GraphDetectCycle {

    public static void main(String[] args) {
        int nodes= 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(nodes);
        //Vertex - 0
        ArrayList<Integer> neighbors = new ArrayList<>();
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 1
        neighbors = new ArrayList<Integer>();
        neighbors.add(2);
        neighbors.add(5);
        graph.add(neighbors);

        //Vertex - 2
        neighbors = new ArrayList<Integer>();
        neighbors.add(3);
        graph.add(neighbors);

        //Vertex - 3
        neighbors = new ArrayList<Integer>();
        neighbors.add(4);
        graph.add(neighbors);

        //Vertex - 4
        neighbors = new ArrayList<Integer>();
        neighbors.add(0);
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 5
        neighbors = new ArrayList<Integer>();
        graph.add(neighbors);

        if(isCyclic(nodes, graph))
            System.out.println("Cycle detected");
        else
            System.out.println("No cycles detected");
    }

    private static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int visted[], int dfsVisited[]) {
        visted[node] = 1;
        dfsVisited[node] = 1;
        System.out.println(node + "   ======   "+adj.get(node));
        for(Integer neighbor: adj.get(node)) {
            if(visted[neighbor] == 0) {
                if(checkCycle(neighbor, adj, visted, dfsVisited) == true) {
                    return true;
                }
            } else if(dfsVisited[neighbor] == 1) {
                return true;
            }
        }
        dfsVisited[node] = 0;
        return false;
    }

    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[N];
        int dfsVis[] = new int[N];

        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis) == true) return true;
            }
        }
        return false;
    }

}
