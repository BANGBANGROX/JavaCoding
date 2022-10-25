import java.util.Scanner;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
         StringBuilder str1 = new StringBuilder();
         StringBuilder str2 = new StringBuilder();

         for (String word : word1) {
             str1.append(word);
         }

         for (String word : word2) {
             str2.append(word);
         }

         return str1.compareTo(str2) == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            String[] word1 = new String[m];
            for (int i = 0; i < m; ++i) {
                word1[i] = sc.next();
            }
            int n = sc.nextInt();
            String[] word2 = new String[n];
            for (int i = 0; i < n; ++i) {
                word2[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.arrayStringsAreEqual(word1, word2));
        }

        sc.close();
    }
}
