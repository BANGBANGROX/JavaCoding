//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    private List<List<Pair>> graph;
    private int n;

    private static class Pair {
        int node;
        int distance;

        Pair(final int node, final int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public boolean equals(final Object object) {
            if (!(object instanceof final Pair objectPair)) return false;

            return objectPair.distance == distance && objectPair.node == node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, distance);
        }
    }

    private int getShortestDistance(final int source, final int destination) {
        final PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        final int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        pairPriorityQueue.add(new Pair(source, distance[source]));

        while (!pairPriorityQueue.isEmpty()) {
            final Pair currentPair = pairPriorityQueue.poll();
            final int node = currentPair.node;
            final int currentDistance = currentPair.distance;
            for (final Pair childPair : graph.get(node)) {
                final int childNode = childPair.node;
                final int childDistance = childPair.distance;
                // Ignore direct edge
                if ((node == source && childNode == destination) || (node == destination || childNode == source)) {
                    continue;
                }
                if (distance[childNode] > currentDistance + childDistance) {
                    pairPriorityQueue.remove(new Pair(childNode, distance[childNode]));
                    distance[childNode] = childDistance + currentDistance;
                    pairPriorityQueue.add(new Pair(childNode, distance[childNode]));
                }
            }
        }

        return distance[destination];
    }

    public int findMinCycle(final int n, final int[][] edges) {
        // code here
        graph = new ArrayList<>();
        this.n = n;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (final int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        for (final int[] edge : edges) {
            int currentCycleWeight = getShortestDistance(edge[0], edge[1]);
            if (currentCycleWeight != Integer.MAX_VALUE) {
                answer = Math.min(answer, currentCycleWeight + edge[2]);
            }
        }

        return answer;
    }
}