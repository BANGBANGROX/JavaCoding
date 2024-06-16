import java.util.Scanner;

class Solution {
    public int minPatches(int[] nums, int n) {
        long currentReach = 0;
        int i = 0;
        int answer = 0;
        int len = nums.length;

        while (currentReach < n) {
            if (i >= len) {
                currentReach += (currentReach + 1);
                ++answer;
            } else if (nums[i] <= currentReach + 1) {
                currentReach += nums[i];
                ++i;
            } else {
                ++answer;
                currentReach += (currentReach + 1);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int len = sc.nextInt();
            int[] nums = new int[len];
            for (int i = 0; i < len; ++i) {
                nums[i] = sc.nextInt();
            }
            int n = sc.nextInt();

            System.out.println(new Solution().minPatches(nums, n));
        }

        sc.close();
    }
}
