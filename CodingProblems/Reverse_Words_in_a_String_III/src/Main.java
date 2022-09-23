import java.util.Scanner;

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            StringBuilder currentWord = new StringBuilder();
            while (i < n && s.charAt(i) != ' ') {
                currentWord.append(s.charAt(i));
                ++i;
            }
            currentWord.reverse();
            if (!ans.isEmpty()) {
                ans.append(' ');
            }
            ans.append(currentWord);
        }

        return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.reverseWords(s));
        }

        sc.close();
    }
}
