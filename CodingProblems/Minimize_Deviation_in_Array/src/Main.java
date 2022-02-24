import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int minimumDeviation(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            if ((num & 1) > 0) {
                num *= 2;
            }
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
            pq.add(num);
        }

        int ans = maxNum - minNum;

        while ((pq.peek() & 1) == 0) {
            int top = pq.poll();
            ans = Math.min(ans, top - minNum);
            top /= 2;
            minNum = Math.min(minNum, top);
            pq.add(top);
        }

        ans = Math.min(ans, pq.peek() - minNum);

        return ans;
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
            System.out.println(solution.minimumDeviation(nums));
        }

        sc.close();
    }
}
