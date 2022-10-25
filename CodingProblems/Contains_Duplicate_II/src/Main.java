import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> index = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (!index.containsKey(nums[i])) {
                index.put(nums[i], i);
                continue;
            }
            int idx = index.get(nums[i]);
            if (i - idx <= k) return true;
            index.put(nums[i], i);
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
            System.out.println(solution.containsNearbyDuplicate(nums, k));
        }

        sc.close();
    }
}
