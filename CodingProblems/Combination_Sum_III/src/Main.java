import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    private List<List<Integer>> ans;
    private List<Integer> currentCombination;
    private final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private void combinationSum3Util(int k, int n, int index) {
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(currentCombination));
            return;
        }

        if (k == 0 || index == nums.length || n < 0) return;

        combinationSum3Util(k, n, index + 1);

        currentCombination.add(nums[index]);
        combinationSum3Util(k - 1, n - nums[index], index + 1);
        currentCombination.remove(currentCombination.size() - 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        currentCombination = new ArrayList<>();

        combinationSum3Util(k, n, 0);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.combinationSum3(k, n));
        }

        sc.close();
    }
}
