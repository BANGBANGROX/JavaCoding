import java.util.Scanner;

class Solution {
    public int minFlipsMonoIncr(String s) {
         int oneCount = 0;
         int flipCount = 0;

         for (char ch : s.toCharArray()) {
             if (ch == '0') {
                 ++flipCount;
                 flipCount = Math.min(flipCount, oneCount);
             }
             else ++oneCount;
         }

         return flipCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minFlipsMonoIncr(s));
        }

        sc.close();
    }
}
