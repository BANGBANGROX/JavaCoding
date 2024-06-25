import java.util.Scanner;

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int answer = 0;
        int flipCnt = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (i >= k && nums[i - k] == 2) {
                --flipCnt;
            }
            if (flipCnt % 2 == nums[i]) {
                if (i + k > n) return -1;
                ++answer;
                ++flipCnt;
                nums[i] = 2;
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
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();

            System.out.println(new Solution().minKBitFlips(nums, k));
        }

        scanner.close();
    }
}
