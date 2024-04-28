import java.util.Scanner;
import java.util.Stack;

class Solution {
    public long numberOfSubarrays(int[] nums) {
        long subArrayCount = 0;
        Stack<int[]> numAndCount = new Stack<>();

        for (int num : nums) {
            while (!numAndCount.isEmpty() && numAndCount.peek()[0] < num) {
                numAndCount.pop();
            }
            if (numAndCount.isEmpty() || numAndCount.peek()[0] != num) {
                numAndCount.push(new int[]{num, 0});
            }
            ++numAndCount.peek()[1];
            subArrayCount += numAndCount.peek()[1];
        }

        return subArrayCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int totalNums = sc.nextInt();
            int[] nums = new int[totalNums];
            for (int i = 0; i < totalNums; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.numberOfSubarrays(nums));
        }

        sc.close();
    }
}
