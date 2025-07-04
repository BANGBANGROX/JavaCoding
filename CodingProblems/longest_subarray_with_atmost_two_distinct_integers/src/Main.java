import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int totalElements(final int[] arr) {
        // code here
        final int n = arr.length;
        int answer = 0;
        int left = 0;
        int distinctNums = 0;
        final Map<Integer, Integer> count = new HashMap<>();

        for (int right = 0; right < n; ++right) {
            count.put(arr[right], count.getOrDefault(arr[right], 0) + 1);
            if (count.get(arr[right]) == 1) {
                ++distinctNums;
            }
            while (distinctNums > 2) {
                count.put(arr[left], count.get(arr[left]) - 1);
                if (count.get(arr[left]) == 0) {
                    --distinctNums;
                }
                ++left;
            }
            answer = Math.max(answer, right - left + 1);
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

           System.out.println(new Solution().totalElements(arr));
       }
       
       scanner.close();
   }
}
