import java.util.*;

class Solution {
    private ArrayList<ArrayList<ArrayList<Integer>>> buildGraphFromEdges(int[][] edges, int totalNodes) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();

        for (int i = 0; i < totalNodes; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new ArrayList<>(Arrays.asList(edge[1], edge[2])));
            graph.get(edge[1]).add(new ArrayList<>(Arrays.asList(edge[0], edge[2])));
        }

        return graph;
    }

    private int[] computeDistancesFromNode(int[][] edges, int source, int totalNodes, int[] disappearingTimes) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph = buildGraphFromEdges(edges, totalNodes);
        int[] distances = new int[totalNodes];
        TreeSet<ArrayList<Integer>> nodesDistanceData = new TreeSet<>((a, b) -> !Objects.equals(a.get(1), b.get(1)) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));


        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        nodesDistanceData.add(new ArrayList<>(Arrays.asList(source, distances[source])));

        while (!nodesDistanceData.isEmpty()) {
            ArrayList<Integer> currentNodeDistanceData = nodesDistanceData.pollFirst();
            assert currentNodeDistanceData != null;
            int currentNode = currentNodeDistanceData.get(0);
            int currentDistance = currentNodeDistanceData.get(1);
            for (ArrayList<Integer> childNodesData : graph.get(currentNode)) {
                int childNode = childNodesData.get(0);
                int edgeWeight = childNodesData.get(1);
                if (distances[childNode] > currentDistance + edgeWeight && (currentDistance + edgeWeight < disappearingTimes[childNode])) {
                    nodesDistanceData.remove(new ArrayList<>(Arrays.asList(childNode, distances[childNode])));
                    distances[childNode] = currentDistance + edgeWeight;
                    nodesDistanceData.add(new ArrayList<>(Arrays.asList(childNode, distances[childNode])));
                }
            }
        }

        for (int i = 0; i < totalNodes; ++i) {
            if (distances[i] == Integer.MAX_VALUE) {
                distances[i] = -1;
            }
        }

        return distances;
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        return computeDistancesFromNode(edges, 0, n, disappear);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int totalNodes = sc.nextInt();
            int totalEdges = sc.nextInt();
            int[][] edges = new int[totalEdges][3];
            for (int i = 0; i < totalEdges; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            int[] disappear = new int[totalNodes];
            for (int i = 0; i < totalNodes; ++i) {
                disappear[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] distances = solution.minimumTime(totalNodes, edges, disappear);
            for (int x : distances) {
                System.out.println(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
