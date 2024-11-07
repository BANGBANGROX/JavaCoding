import java.util.Scanner;

class Solution {
    public int largestCombination(int[] candidates) {
        int answer = 0;

        for (int bit = 0; bit < 32; ++bit) {
            int setBitCnt = 0;
            for (int candidate : candidates) {
                if ((candidate & (1 << bit)) > 0) {
                    ++setBitCnt;
                }
            }
            answer = Math.max(answer, setBitCnt);
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
           int[] candidates = new int[n];
           for (int i = 0; i < n; ++i) {
               candidates[i] = scanner.nextInt();
           }

           System.out.println(new Solution().largestCombination(candidates));
       }
       
       scanner.close();
   }
}
