import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int answer = 0;
        int n = answerKey.length();
        HashMap<Character, Integer> count = new HashMap<>();

        for (int right = 0; right < n; ++right) {
            count.put(answerKey.charAt(right),
                    count.getOrDefault(answerKey.charAt(right), 0) + 1);
            int minor = Math.min(count.getOrDefault('T', 0), count.getOrDefault('F', 0));
            if (minor <= k) {
                ++answer;
            }
            else {
                count.put(answerKey.charAt(right - answer),
                        count.get(answerKey.charAt(right - answer)) - 1);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String answerKey = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maxConsecutiveAnswers(answerKey, k));
        }

        sc.close();
    }
}
