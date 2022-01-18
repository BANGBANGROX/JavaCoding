import java.util.Scanner;

class Solution {
    public int myAtoi(String s) {
         int result = 0;
         int sign = 1;
         int index = 0;
         int n = s.length();

         while (index < n && s.charAt(index) == ' ') {
             ++index;
         }

         if (index < n && s.charAt(index) == '+') {
             ++index;
         }
         else if (index < n && s.charAt(index) == '-') {
             sign = -1;
             ++index;
         }

         while (index < n && Character.isDigit(s.charAt(index))) {
             int digit = s.charAt(index) - '0';
             if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 &&
                     digit > Integer.MAX_VALUE % 10 )) {
                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
             }
             result = result * 10 + digit;
             ++index;
         }

         return sign * result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.nextLine();

            Solution solution = new Solution();
            System.out.println(solution.myAtoi(s));
        }

        sc.close();
    }
}
