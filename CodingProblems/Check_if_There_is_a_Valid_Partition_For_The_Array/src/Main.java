import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private Map<Integer, Boolean> dp;
    private int[] nums;

    private boolean validPartitionHandler(int index) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        boolean result = false;

        if (index > 0 && nums[index] == nums[index - 1]) {
            result = validPartitionHandler(index - 2);
        }

        if (index > 1 && ((nums[index] == nums[index - 1] && nums[index - 1] == nums[index - 2]) || (
                nums[index] == nums[index - 1] + 1 && nums[index - 1] == nums[index - 2] + 1
        ))) {
            result |= validPartitionHandler(index - 3);
        }

        dp.put(index, result);

        return result;
    }

    public boolean validPartition(int[] nums) {
        dp = new HashMap<>();
        this.nums = nums;

        dp.put(-1, true);

        return validPartitionHandler(nums.length - 1);
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
            System.out.println(solution.validPartition(nums));
        }

        sc.close();
    }
}
