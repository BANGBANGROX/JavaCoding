import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private int toInteger(String word) {
       int mask = 0;
       int n = word.length();

       for (int i = 0; i < n; ++i) {
           mask += (1 << (word.charAt(i) - 'a'));
       }

       return mask;
    }

    public int wordCount(String[] startWords, String[] targetWords) {
         Set<Integer> st = new HashSet<>();
         int ans = 0;

         for (String word : startWords) {
             st.add(toInteger(word));
         }

         for (String word : targetWords) {
             int mask = toInteger(word);
             for (int i = 0; i < 26; ++i) {
                 if ((mask & (1 << i)) > 0) {
                     mask -= (1 << i);
                     if (st.contains(mask)) {
                         ++ans;
                         break;
                     }
                     mask += (1 << i);
                 }
             }
         }

         return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            String[] startWords = new String[m];
            for (int i = 0; i < m; ++i) startWords[i] = sc.next();
            int n = sc.nextInt();
            String[] targetWords = new String[n];
            for (int i = 0; i < n; ++i) targetWords[i] = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.wordCount(startWords, targetWords));
        }

        sc.close();
    }
}
