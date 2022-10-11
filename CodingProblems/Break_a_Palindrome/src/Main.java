import java.util.Scanner;

class Solution {
    public String breakPalindrome(String palindrome) {
         char[] strArr = palindrome.toCharArray();
         int n = strArr.length;
         boolean done = false;

         if (n == 1) return "";

         for (int i = 0; i < n / 2; ++i) {
             if (strArr[i] != 'a') {
                 strArr[i] = 'a';
                 done = true;
                 break;
             }
         }

         if (!done) {
             strArr[n - 1] = 'b';
         }

         return new String(strArr);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String palindrome = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.breakPalindrome(palindrome));
        }

        sc.close();
    }
}
