import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public long maxKelements(int[] nums, int k) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -1 * a));

        for (int num : nums) {
            pq.add(num);
        }

        while (k > 0 && !pq.isEmpty()) {
            int num = pq.poll();
            answer += num;
            pq.add((int) Math.ceil(1.0 * num / 3));
            --k;
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

           System.out.println(new Solution().maxKelements(nums, k));
       }
       
       scanner.close();
   }
}
