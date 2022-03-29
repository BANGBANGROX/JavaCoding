import java.util.Scanner;

class Solution {
    public int findDuplicate(int[] nums) {
        int repeatedNumber = -1;

        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) repeatedNumber = nums[i];
            nums[index] *= -1;
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Math.abs(nums[i]);
        }

        return repeatedNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.findDuplicate(nums));
        }

        sc.close();
    }
}
