import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] visited;
    private int componentSize;

    private void dfs(int node) {
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
            }
        }

        ++componentSize;
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

        assert n > 0;

        int maxNum = Arrays.stream(nums).max().getAsInt();
        HashMap<Integer, ArrayList<Integer>> numIndices = new HashMap<>();
        boolean[] sieve = new boolean[maxNum + 1];
        componentSize = 0;
        graph = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            numIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            graph.add(new ArrayList<>());
        }

        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i <= maxNum; ++i) {
            if (sieve[i]) {
                int lastIdx = -1;
                for (int j = i; j <= maxNum; j += i) {
                    if (j > i) {
                        sieve[j] = false;
                    }
                    for (int idx : numIndices.getOrDefault(j, new ArrayList<>())) {
                        if (lastIdx != -1) {
                            graph.get(lastIdx).add(idx);
                            graph.get(idx).add(lastIdx);
                        }
                        lastIdx = idx;
                    }
                }
            }
        }

        dfs(0);

        return componentSize == n;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.canTraverseAllPairs(nums));
        }

        sc.close();
    }
}
