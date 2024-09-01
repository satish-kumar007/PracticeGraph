package graph1;
/*
Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.



Problem Constraints
1 <= N <= 100000



Input Format
First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format
Return 1 if reachable, 0 otherwise.



Example Input
Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:

 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.


 */
import java.util.ArrayList;

public class AssignmentFirstDepthFirstSearch {
    static ArrayList <ArrayList<Integer>> adj;

    public static void graph(int n, int [] vis) {
        adj = new ArrayList < ArrayList < Integer > > (n);
        for (int i = 0; i < n; i++) {
            vis[i] = 0;
            adj.add(new ArrayList < Integer > ());
        }
        System.out.println(adj);
    }

    public int solve(int[] A, final int B, final int C) {
        int n = A.length;
        int[] vis = new int[n+1];
        graph(n+1, vis);
        for (int i = 1; i < n; i++) {
            adj.get(A[i]).add(i + 1);
        }
        if (dfs(C, B, vis) == true)
            return 1;
        return 0;
    }

    public static boolean dfs(int s, int x, int [] vis) {
        if (s == x)
            return true;
        vis[s] = 1;
        int i, j;
        int k = adj.get(s).size();
        for (i = 0; i < k; i++) {
            j = adj.get(s).get(i);
            if (vis[j] == 0 && dfs(j, x, vis) == true)
                return true;
        }
        return false;
    }
}
