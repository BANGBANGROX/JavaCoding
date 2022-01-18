import java.util.Scanner;

class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int i = 0;
        StringBuilder ans = new StringBuilder();

        while (i < n) {
            StringBuilder currentWord = new StringBuilder();
            while (i < n && s.charAt(i) != ' ') {
                currentWord.append(s.charAt(i));
                ++i;
            }
            if (ans.length() == 0) ans = new StringBuilder(currentWord.toString());
            else ans.insert(0, currentWord.toString() + ' ');
            ++i;
        }

        return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.nextLine();

            Solution solution = new Solution();
            System.out.println(solution.reverseWords(s));
        }

        sc.close();
    }
}
