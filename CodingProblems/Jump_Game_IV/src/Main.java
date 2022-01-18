import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n <= 1) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; ++i) {
           graph.computeIfAbsent(arr[i],v -> new LinkedList<>()).add(i);
        }

        List<Integer> currentNodes = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int steps = 0;

        currentNodes.add(0);
        visited.add(0);

        while (!currentNodes.isEmpty()) {
            List<Integer> nextNode = new LinkedList<>();
            for (int node : currentNodes) {
                if (node == n - 1) return steps;

                for (int childNode : graph.get(arr[node])) {
                    if (visited.contains(childNode)) continue;
                    visited.add(childNode);
                    nextNode.add(childNode);
                }

                graph.get(arr[node]).clear();

                if (node + 1 < n && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    nextNode.add(node + 1);
                }

                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    nextNode.add(node - 1);
                }
            }

            currentNodes = nextNode;
            ++steps;
        }

        return steps;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.minJumps(arr));
        }

        sc.close();
    }
}
