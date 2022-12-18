import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        boolean[] present1 = new boolean[26];
        boolean[] present2 = new boolean[26];

        for (char ch : word1.toCharArray()) {
            ++count1[ch - 'a'];
            present1[ch - 'a'] = true;
        }

        for (char ch : word2.toCharArray()) {
            ++count2[ch - 'a'];
            present2[ch - 'a'] = false;
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        for (int i = 0; i < 26; ++i) {
            if (count1[i] != count2[i] || present1[i] != present2[i]) return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String word1 = sc.next();
            String word2 = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.closeStrings(word1, word2));
        }

        sc.close();
    }
}
