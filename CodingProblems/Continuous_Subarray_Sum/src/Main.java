import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int currentSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            currentSum += num;
            currentSum %= k;
            if (currentSum == 0 && i > 0) return true;
            if (mp.containsKey(currentSum)) {
                int len = i - mp.get(currentSum);
                if (len >= 2) return true;
            }
            else mp.put(currentSum, i);
        }

        return false;
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.checkSubarraySum(nums, k));
        }

        sc.close();
    }
}
