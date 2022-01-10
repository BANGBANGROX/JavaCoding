import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int getMaxLen(int[] nums) {
        nums = Arrays.copyOf(nums, nums.length + 1);

        int n = nums.length, l = -1, r = -1, lastZero = 0, maxLen = 0, negCount = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                ++negCount;
                if (l == -1) l = i;
                r = i;
            }
            else if (nums[i] == 0) {
                if (negCount % 2 == 0) {
                    maxLen = Math.max(maxLen, i - lastZero);
                }
                else {
                    maxLen = Math.max(maxLen, Math.max(i - l - 1, r - lastZero));
                }
                lastZero = i + 1;
                negCount = 0;
                l = -1;
                r = -1;
            }
        }

        return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.getMaxLen(nums));

        sc.close();
    }
}
