//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) ->
                (!Objects.equals(a.get(0), b.get(0)) ? a.get(0) - b.get(0) : a.get(1) -
                        b.get(1)));
        int[] distance = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> road: roads) {
            int u = road.get(0);
            int v = road.get(1);
            int wt = road.get(2);
            graph.get(u).add(new ArrayList<>(Arrays.asList(v, wt)));
            graph.get(v).add(new ArrayList<>(Arrays.asList(u, wt)));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new ArrayList<>(Arrays.asList(0, 0)));
        distance[0] = 0;
        count[0] = 1;

        while (!pq.isEmpty()) {
            ArrayList<Integer> nodeList = pq.poll();
            int node = nodeList.get(1);
            int dis = nodeList.get(0);
            if (dis > distance[node]) continue;
            for (ArrayList<Integer> childList: graph.get(node)) {
                int child = childList.get(0);
                int wt = childList.get(1);
                if (distance[child] > dis + wt) {
                    distance[child] = dis + wt;
                    count[child] = count[node];
                    pq.add(new ArrayList<>(Arrays.asList(distance[child], child)));
                }
                else if (distance[child] == dis + wt) count[child] += count[node];
            }
        }

        return count[n - 1];
    }
}
