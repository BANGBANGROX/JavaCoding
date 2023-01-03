import java.util.Scanner;

class Solution {
    public int takeCharacters(String s, int k) {
         int[] count = new int[3];
         int n = s.length();
         int ans = n;

         for (char ch : s.toCharArray()) {
             ++count[ch - 'a'];
         }

         if (count[0] < k || count[1] < k || count[2] < k) return -1;

         int i = n - 1;
         int j = n - 1;

         while (i >= 0) {
             --count[s.charAt(i) - 'a'];
             while (count[0] < k || count[1] < k || count[2] < k) {
                 ++count[s.charAt(j) - 'a'];
                 --j;
             }
             ans = Math.min(ans, i + n - 1 - j);
             --i;
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.takeCharacters(s, k));
        }

        sc.close();
    }
}
