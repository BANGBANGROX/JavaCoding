import java.util.Scanner;

class Solution {
    public int countConsec(final int n) {
        // code here
        int first = 0;
        int second = 1;
        int answer = 1;

        for (int i = 3; i <= n; ++i) {
            final int third = (first + second);
            first = second;
            second = third;
            answer = (answer * 2 + third);
        }

        return answer;
    }
}


public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().countConsec(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
