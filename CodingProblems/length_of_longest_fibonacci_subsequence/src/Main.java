import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> numSet = new HashSet<>();
        
        for (int num : arr) {
            numSet.add(num);
        }

        int maxLen = 0;
        for (int start = 0; start < n; ++start) {
            for (int next = start + 1; next < n; ++next) {
                int prev = arr[next];
                int curr = arr[start] + arr[next];
                int len = 2;

                while (numSet.contains(curr)) {
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    maxLen = Math.max(maxLen, ++len);
                }
            }
        }

        return maxLen;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] arr = new int[n];
           for (int i = 0; i < n; ++i) {
               arr[i] = scanner.nextInt();
           }

           System.out.println(new Solution().lenLongestFibSubseq(arr));
       }
       
       scanner.close();
   }
}
