import java.util.Scanner;

class Solution {
    public int minMovesToMakePalindrome(String s) {
         int ans = 0;
         int left = 0;
         int right = s.length() - 1;
         char[] str = s.toCharArray();

         while (left < right) {
             int l = left;
             int r = right;
             while (str[l] != str[r]) --r;
             if (l == r) {
                 ++ans;
                 char temp = str[r];
                 str[r] = str[r + 1];
                 str[r + 1] = temp;
                 continue;
             }
             while (r < right) {
                 char temp = str[r];
                 str[r] = str[r + 1];
                 str[r + 1] = temp;
                 ++ans;
                 ++r;
             }
             ++left;
             --right;
         }

         return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minMovesToMakePalindrome(s));
        }

        sc.close();
    }
}
