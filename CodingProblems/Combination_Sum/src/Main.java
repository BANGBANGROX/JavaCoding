import java.util.*;

class Solution {
    private List<List<Integer>> ans;
    private List<Integer> currentCombination;

    private void combinationSumUtil(int[] candidates, int index, int target) {
        if (index == candidates.length) return;

        if (target == 0) {
            ans.add(new ArrayList<>(currentCombination));
            return;
        }

        if (candidates[index] > target) return;

        combinationSumUtil(candidates,index + 1, target);

        currentCombination.add(candidates[index]);
        combinationSumUtil(candidates, index,target - candidates[index]);
        currentCombination.remove(currentCombination.size() - 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        currentCombination = new ArrayList<>();
        ans = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSumUtil(candidates,0,target);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; ++i) {
                candidates[i] = sc.nextInt();
            }
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.combinationSum(candidates, target));
        }

        sc.close();
    }
}
