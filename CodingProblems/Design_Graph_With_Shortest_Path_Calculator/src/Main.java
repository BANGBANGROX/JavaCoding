import java.util.*;

class Graph {
    private final ArrayList<ArrayList<ArrayList<Integer>>> graph;
    private final int n;

    private int computeDistance(int src, int dest) {
        int[] distance = new int[n];
        TreeSet<ArrayList<Integer>> st = new TreeSet<>((a, b) ->
                !Objects.equals(a.get(0), b.get(0)) ? a.get(0) - b.get(0) :
                a.get(1) - b.get(1));

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        st.add(new ArrayList<>(Arrays.asList(distance[src], src)));

        while (!st.isEmpty()) {
            ArrayList<Integer> current = st.pollFirst();
            assert current != null;
            int node = current.get(1);
            int dist = current.get(0);
            if (node == dest) return dist;
            for (ArrayList<Integer> currentEdge: graph.get(node)) {
                int child = currentEdge.get(0);
                int wt = currentEdge.get(1);
                if (distance[child] > wt + dist) {
                    st.remove(new ArrayList<>(Arrays.asList(distance[child], child)));
                    distance[child] = wt + dist;
                    st.add(new ArrayList<>(Arrays.asList(distance[child], child)));
                }
            }
        }

        return -1;
    }

    public Graph(int n, int[][] edges) {
         graph = new ArrayList<>();
         this.n = n;

         for (int i = 0; i < n; ++i) {
             graph.add(new ArrayList<>());
         }

         for (int[] edge : edges) {
             int u = edge[0];
             int v = edge[1];
             int wt = edge[2];
             graph.get(u).add(new ArrayList<>(Arrays.asList(v, wt)));
         }
    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];

        graph.get(u).add(new ArrayList<>(Arrays.asList(v, wt)));
    }

    public int shortestPath(int node1, int node2) {
        return computeDistance(node1, node2);
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
