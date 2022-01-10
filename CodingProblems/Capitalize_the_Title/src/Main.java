import java.util.Scanner;

class Solution {
    public String capitalizeTitle(String title) {
        int n = title.length();
        String ans = "";

        for (int i = 0; i < n; ++i) {
            String currWord = "";
            while (i < n && title.charAt(i) != ' ') {
                currWord += title.charAt(i);
                ++i;
            }
            if (currWord.length() <= 2) {
                currWord = currWord.toLowerCase();
            }
            else {
               String firstLetter = currWord.substring(0, 1);
               String remainingString = currWord.substring(1).toLowerCase();
               firstLetter = firstLetter.toUpperCase();
               currWord = firstLetter + remainingString;
            }
            ans = ans + currWord;
            if (i != n) ans += ' ';
        }


        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String title = sc.nextLine();

            Solution solution = new Solution();
            System.out.println(solution.capitalizeTitle(title));
        }

        sc.close();
    }
}
