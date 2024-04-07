import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private int subarrayWithAtMostK(int[] nums, int k) {
        int result = 0;
        int n = nums.length;
        int l = 0;
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int r = 0; r < n; ++r) {
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
            while (count.size() > k) {
                count.put(nums[l], count.get(nums[l]) - 1);
                if (count.get(nums[l]) == 0) {
                    count.remove(nums[l]);
                }
                ++l;
            }
            result += (r - l + 1);
        }

        return result;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayWithAtMostK(nums, k) - subarrayWithAtMostK(nums, k - 1);
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
            System.out.println(solution.subarraysWithKDistinct(nums, k));
        }

        sc.close();
    }
}
