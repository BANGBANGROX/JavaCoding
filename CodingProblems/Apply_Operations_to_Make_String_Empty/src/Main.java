import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public String lastNonEmptyString(String s) {
        int[] count = new int[26];
        String answer = s;

        for (char ch : s.toCharArray()) {
            ++count[ch - 'a'];
        }

        int maxCount = Arrays.stream(count).max().getAsInt();

        if (maxCount == 1) return answer;

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            StringBuilder nextAnswer = new StringBuilder();
            int cnt = maxCount - 1;
            for (char strChar : answer.toCharArray()) {
                if (strChar != ch || cnt == 0) {
                    nextAnswer.append(strChar);
                }
                else {
                    --cnt;
                }
            }
            answer = nextAnswer.toString();
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

            Solution solution = new Solution();
            System.out.println(solution.lastNonEmptyString(s));
        }

        sc.close();
    }
}
