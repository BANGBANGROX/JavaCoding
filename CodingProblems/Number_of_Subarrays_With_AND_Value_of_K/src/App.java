import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        long answer = 0;
        Map<Integer, Long> previousCount = new HashMap<>();
        
        for (int num : nums) {
            Map<Integer, Long> currentCount = new HashMap<>();
            for (Map.Entry<Integer, Long> entry : previousCount.entrySet()) {
                int andValue = entry.getKey() & num;
                long cnt = entry.getValue();
                currentCount.put(andValue, currentCount.getOrDefault(andValue, 0L) + cnt);
            }
            currentCount.put(num, currentCount.getOrDefault(num, 0L) + 1);
            answer += currentCount.getOrDefault(k, 0L);
            previousCount = currentCount;
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();

            System.out.println(new Solution().countSubarrays(nums, k));
        }

        scanner.close();
    }
}
