import java.util.Scanner;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] answer = new int[n];
        int[] prefixSum = new int[n];

        for (int i = 0; i < n; ++i) {
            prefixSum[i] = code[i] + (i > 0 ? prefixSum[i - 1] : 0);
        }

        for (int i = 0; i < n; ++i) {
            int result = 0;
            if (k > 0) {
                int elementsNeeded = i + k - n + 1;
                result = prefixSum[Math.min(n - 1, i + k)] - prefixSum[i];
                if (elementsNeeded > 0) {
                    result += prefixSum[elementsNeeded - 1];
                }
            } else if (k < 0) {
                int elementsNeeded = -1 * k - i;
                if (i > 0) {
                    result = prefixSum[i - 1];
                    if (i + k > 0) {
                        result -= prefixSum[i + k - 1];
                    }
                }
                if (elementsNeeded > 0) {
                    result += (prefixSum[n - 1] - prefixSum[n - elementsNeeded - 1]);
                }
            }
            answer[i] = result;
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
           int[] code = new int[n];
           for (int i = 0; i < n; ++i) {
               code[i] = scanner.nextInt();
           }
           int k = scanner.nextInt();

           int[] answer = new Solution().decrypt(code, k);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
