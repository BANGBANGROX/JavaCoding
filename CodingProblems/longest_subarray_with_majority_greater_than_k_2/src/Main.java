import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int longestSubarray(final int[] arr, final int k) {
        // Code Here
        final Map<Integer, Integer> firstIndex = new HashMap<>();
        int runningCounter = 0;
        final int n = arr.length;
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            runningCounter += (arr[i] > k ? 1 : -1);

            if (runningCounter > 0) {
                answer = i + 1;
            }

            if (firstIndex.containsKey(runningCounter - 1)) {
                answer = Math.max(answer, i - firstIndex.get(runningCounter - 1));
            }

            firstIndex.putIfAbsent(runningCounter, i);
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

           System.out.println(new Solution().longestSubarray(arr, k));
       }
       
       scanner.close();
   }
}
