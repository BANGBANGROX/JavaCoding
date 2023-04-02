//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);

            String[] S1 = read.readLine().split(" ");
            int a = Integer.parseInt(S1[0]);
            int b = Integer.parseInt(S1[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] S2 = read.readLine().split(" ");
                int u = Integer.parseInt(S2[0]);
                int v = Integer.parseInt(S2[1]);
                int x = Integer.parseInt(S2[2]);
                int y = Integer.parseInt(S2[3]);

                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edge.add(x);
                edge.add(y);

                edges.add(edge);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestPath(n, a, b, edges));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int shortestPath(int n, int src, int target,
                            ArrayList<ArrayList<Integer>> edges) {
        // code here
        if (src == target) return 0;

        --src;
        --target;

        int[][] distance = new int[n][2];
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>
                (Comparator.comparingInt(a -> a.get(1)));

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
            distance[i][0] = distance[i][1] = Integer.MAX_VALUE;
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            int w1 = edge.get(2);
            int w2 = edge.get(3);
            graph.get(u).add(new int[]{v, w1, w2});
            graph.get(v).add(new int[]{u, w1, w2});
        }

        distance[src][0] = distance[src][1] = 0;
        pq.add(new ArrayList<>(Arrays.asList(src, distance[src][0], 1)));

        while (!pq.isEmpty()) {
            ArrayList<Integer> current = pq.poll();
            int node = current.get(0);
            int dist = current.get(1);
            int left = current.get(2);
            for (int[] childNode : graph.get(node)) {
                int child = childNode[0];
                int w1 = childNode[1];
                int w2 = childNode[2];
                if (dist + w1 < distance[child][left]) {
                    ArrayList<Integer> next = new ArrayList<>(Arrays.asList(child, distance[child][left], left));
                    pq.remove(next);
                    distance[child][left] = w1 + dist;
                    next.set(1, distance[child][left]);
                    pq.add(next);
                }
                if (left > 0 && dist + w2 < distance[child][left - 1]) {
                    ArrayList<Integer> next = new ArrayList<>(Arrays.asList(child,
                            distance[child][left - 1], left - 1));
                    pq.remove(next);
                    distance[child][left - 1] = w2 + dist;
                    next.set(1, distance[child][left - 1]);
                    pq.add(next);
                }
            }
        }

        int ans = Math.min(distance[target][0], distance[target][1]);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}