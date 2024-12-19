import java.util.Scanner;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int answer = 0;
        int n = arr.length;
        int maxValue = 0;

        for (int i = 0; i < n; ++i) {
            maxValue = Math.max(maxValue, arr[i]);
            if (maxValue == i) {
                ++answer;
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
           int[] arr = new int[n];
           for (int i = 0; i < n; ++i) {
               arr[i] = scanner.nextInt();
           }

           System.out.println(new Solution().maxChunksToSorted(arr));
       }
       
       scanner.close();
   }
}
