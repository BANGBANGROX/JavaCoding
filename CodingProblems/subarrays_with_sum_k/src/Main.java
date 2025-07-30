import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int cntSubarrays(final int[] arr, final int k) {
        // code here
        int runningSum = 0;
        int answer = 0;
        final Map<Integer, Integer> count = new HashMap<>();

        for (final int num : arr) {
            runningSum += num;
            if (runningSum == k) {
                ++answer;
            }
            answer += count.getOrDefault(runningSum - k, 0);
            count.put(runningSum, count.getOrDefault(runningSum, 0) + 1);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] arr = new int[n];
           for (int i = 0; i < n; ++i) {
               arr[i] = scanner.nextInt();
           }
           final int k = scanner.nextInt();

           System.out.println(new Solution().cntSubarrays(arr, k));
       }
       
       scanner.close();
   }
}
