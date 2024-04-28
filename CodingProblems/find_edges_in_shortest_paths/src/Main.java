import java.util.*;

class Solution {
    private ArrayList<ArrayList<ArrayList<Integer>>> graph;
    private HashMap<String, Integer> nodePairToEdgeNumber;
    private HashSet<Integer>[] shortestPaths;
    private boolean[] answer;

    private void findEdgesInShortestPaths(int node) {
        if (shortestPaths[node].isEmpty()) return;

        HashSet<Integer> edgeSet = shortestPaths[node];

        for (int edge : edgeSet) {
            String edgePair = edge + "|" + node;
            answer[nodePairToEdgeNumber.get(edgePair)] = true;
            findEdgesInShortestPaths(edge);
        }
    }

    private void shortestDistancePaths(int source, int n) {
        shortestPaths = new HashSet[n];
        TreeSet<ArrayList<Integer>> pathData = new TreeSet<>((a, b) -> !Objects.equals(a.get(1), b.get(1)) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        int[] distances = new int[n];

        for (int i = 0; i < n; ++i) {
            shortestPaths[i] = new HashSet<>();
            distances[i] = Integer.MAX_VALUE;
        }

        pathData.add(new ArrayList<>(Arrays.asList(source, 0)));
        distances[source] = 0;

        while (!pathData.isEmpty()) {
            ArrayList<Integer> path = pathData.pollFirst();
            assert path != null;
            int node = path.get(0);
            int distance = path.get(1);
            for (ArrayList<Integer> childData : graph.get(node)) {
                int child = childData.get(0);
                int wt = childData.get(1);
                if (distances[child] >= wt + distance) {
                    if (distances[child] > wt + distance) {
                        shortestPaths[child].clear();
                        pathData.remove(new ArrayList<>(Arrays.asList(child, distances[child])));
                        distances[child] = wt + distance;
                        pathData.add(new ArrayList<>(Arrays.asList(child, distances[child])));
                    }
                    shortestPaths[child].add(node);
                }
            }
        }
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        graph = new ArrayList<>();
        nodePairToEdgeNumber = new HashMap<>();
        int totalEdges = edges.length;
        answer = new boolean[totalEdges];

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < totalEdges; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            graph.get(u).add(new ArrayList<>(Arrays.asList(v, wt)));
            graph.get(v).add(new ArrayList<>(Arrays.asList(u, wt)));
            String s1 = u + "|" + v;
            String s2 = v + "|" + u;
            nodePairToEdgeNumber.put(s1, i);
            nodePairToEdgeNumber.put(s2, i);
        }

        shortestDistancePaths(0, n);
        findEdgesInShortestPaths(n - 1);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; ++i) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }

            Solution solution = new Solution();
            boolean[] answer = solution.findAnswer(n, edges);
            for (boolean x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
