import java.util.Scanner;
import java.util.Set;

class Solution {
    public int maxVowels(String s, int k) {
         Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
         int count = 0;
         int n = s.length();

         for (int i = 0; i < k; ++i) {
             count += (vowels.contains(s.charAt(i)) ? 1 : 0);
         }

         int answer = count;

         for (int i = k; i < n; ++i) {
             count += vowels.contains(s.charAt(i)) ? 1 : 0;
             count -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
             answer = Math.max(answer, count);
         }

         return answer;
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
            System.out.println(solution.maxVowels(s, k));
        }

        sc.close();
    }
}
