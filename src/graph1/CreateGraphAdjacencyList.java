package graph1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateGraphAdjacencyList {

    Map<Integer, List<Integer>> adjacencyList;
    public CreateGraphAdjacencyList(){
        adjacencyList = new HashMap<>();
    }

    public void addVertexes(int vertex){
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdges(int source, int destination){
        adjacencyList.get(source).add(destination);

        //Add in case of undirected graph. Otherwise, it will work as directed graph.
        adjacencyList.get(destination).add(source);
    }

    public void printAdjacencyMatrix(){
        for(Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()){
            System.out.print(entry.getKey()+"  -->  ");
            for(Integer neighbour : entry.getValue()){
                System.out.print(neighbour+" ");
            }
            System.out.println();
        }
    }

    public List<Integer> getNeighbors(int vertex){
        return adjacencyList.get(vertex);
    }

    public static void main(String[] args) {
        CreateGraphAdjacencyList graph = new CreateGraphAdjacencyList();
        graph.addVertexes(0);
        graph.addVertexes(1);
        graph.addVertexes(2);
        graph.addVertexes(3);
        graph.addVertexes(4);
        graph.addVertexes(5);
        graph.addVertexes(6);

        graph.addEdges(1, 3);
        graph.addEdges(3, 4);
        graph.addEdges(4, 6);
        graph.addEdges(3, 5);
        graph.addEdges(4,2);
        graph.addEdges(1,2);
        graph.addEdges(2,5);
        graph.addEdges(5,6);

        graph.printAdjacencyMatrix();
    }
}
