//{ Driver Code Starts
// Initial Template for Java

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// Position this line where user code will be pasted.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static class Node {
        int first;
        int second;

        Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        int[] distance = new int[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.first != b.first ?
                a.first - b.first : a.second - b.second);
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            graph.get(u).add(new Node(v, wt));
        }

        pq.add(new Node(0, k));
        distance[k] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int node = currentNode.second;
            int dist = currentNode.first;
            for (Node childNode : graph.get(node)) {
                int child = childNode.first;
                int wt = childNode.second;
                if (distance[child] > dist + wt) {
                    distance[child] = dist + wt;
                    pq.add(new Node(distance[child], child));
                }
            }
        }

        for (int i = 1; i <= n; ++i) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distance[i]);
        }

        return ans;
    }
}
