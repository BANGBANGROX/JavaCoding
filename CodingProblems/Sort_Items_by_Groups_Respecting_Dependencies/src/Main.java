import java.util.*;

class Solution {
    private int[] getTopologicalSort(ArrayList<ArrayList<Integer>> graph,
                                     int[] inDegree, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int child : graph.get(node)) {
                --inDegree[child];
                if (inDegree[child] == 0) {
                    q.add(child);
                }
            }
        }

        if (result.size() < n) {
            result.clear();
        }

        return result.stream().mapToInt(a -> a).toArray();
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;

        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = groupId;
                ++groupId;
            }
        }

        ArrayList<ArrayList<Integer>> itemGraph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> groupGraph = new ArrayList<>();
        int[] itemInDegree = new int[n];
        int[] groupInDegree = new int[groupId];

        for (int i = 0; i < n; ++i) {
            itemGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < groupId; ++i) {
            groupGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            for (int node : beforeItems.get(i)) {
                itemGraph.get(node).add(i);
                ++itemInDegree[i];
                if (group[i] != group[node]) {
                    groupGraph.get(group[node]).add(group[i]);
                    ++groupInDegree[group[i]];
                }
            }
        }

        int[] itemSort = getTopologicalSort(itemGraph, itemInDegree, n);
        int[] groupSort = getTopologicalSort(groupGraph, groupInDegree, groupId);

        if (itemSort.length == 0 || groupSort.length == 0) {
            return new int[]{};
        }

        HashMap<Integer, ArrayList<Integer>> orderedGroups = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int item : itemSort) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        for (int groupInd : groupSort) {
            answer.addAll(orderedGroups.getOrDefault(groupInd, new ArrayList<>()));
        }

        return answer.stream().mapToInt(a -> a).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] group = new int[n];
            for (int i = 0; i < n; ++i) {
                group[i] = sc.nextInt();
            }
            List<List<Integer>> beforeItems = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                ArrayList<Integer> current = new ArrayList<>();
                int cnt = sc.nextInt();
                for (int j = 0; j < cnt; ++j) {
                    current.add(sc.nextInt());
                }
                beforeItems.add(new ArrayList<>(current));
            }

            Solution solution = new Solution();
            int[] answer = solution.sortItems(n, m, group, beforeItems);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
