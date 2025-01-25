import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    private List<List<Integer>> graph;
    private List<Integer> visitedIndices;
    private List<Integer> visitedValues;
    private boolean[] visited;
    private int[] nums;

    private void dfs(int node) {
        visitedIndices.add(node);
        visitedValues.add(nums[node]);
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
            }
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        TreeSet<Integer> numbers = new TreeSet<>();
        Map<Integer, Integer> numIndex = new HashMap<>();
        int[] answer = new int[n];
        visited = new boolean[n];
        graph = new ArrayList<>();
        this.nums = nums;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
            answer[i] = -1;
        }

        numbers.add(nums[0]);
        numIndex.put(nums[0], 0);

        for (int i = 1; i < n; ++i) {
            Integer ceiling = numbers.ceiling(Math.max(nums[i] - limit, 0));
            Integer floor = numbers.floor(nums[i] + limit);
            if (ceiling != null && ceiling <= nums[i] + limit) {
                int idx = numIndex.get(ceiling);
                graph.get(i).add(idx);
                graph.get(idx).add(i);
            }
            if (floor != null && floor >= Math.max(nums[i] - limit, 0) &&
                    !Objects.equals(ceiling, floor)) {
                int idx = numIndex.get(floor);
                graph.get(i).add(idx);
                graph.get(idx).add(i);
            }
            numbers.add(nums[i]);
            if (!numIndex.containsKey(nums[i])) {
                numIndex.put(nums[i], i);
            }
        }

        System.out.println(graph);

        for (int i = 0; i < n; ++i) {
            if (answer[i] == -1) {
                visitedIndices = new ArrayList<>();
                visitedValues = new ArrayList<>();
                dfs(i);
                Collections.sort(visitedIndices);
                Collections.sort(visitedValues);
                for (int j = 0; j < visitedIndices.size(); ++j) {
                    answer[visitedIndices.get(j)] = visitedValues.get(j);
                }
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
       }
       
       scanner.close();
   }
}
