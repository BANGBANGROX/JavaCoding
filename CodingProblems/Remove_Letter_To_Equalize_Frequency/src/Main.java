import java.util.Scanner;

class Solution {
    public boolean equalFrequency(String word) {
         int n = word.length();

         for (int i = 0; i < n; ++i) {
             // Exclude index i
             String newWord = word.substring(0, i) + word.substring(i + 1);
             int[] count = new int[26];
             for (char ch: newWord.toCharArray()) {
                 ++count[ch - 'a'];
             }
             int prevCount = -1;
             boolean isPossible = true;
             for (int j = 0; j < 26; ++j) {
                 if (count[j] == 0) continue;
                 if (prevCount == -1) prevCount = count[j];
                 else if (prevCount != count[j]) {
                     isPossible = false;
                     break;
                 }
                 else prevCount = count[j];
             }
             if (isPossible) return true;
         }

         return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String word = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.equalFrequency(word));
        }

        sc.close();
    }
}
