import java.util.Scanner;

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && boxes.charAt(j) == '1') {
                    answer[i] += Math.abs(i - j);
                }
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
           String boxes = scanner.next();
           int[] answer = new Solution().minOperations(boxes);

           for (int x : answer) {
               System.out.print(x + " ");
           }
       }
       
       scanner.close();
   }
}
