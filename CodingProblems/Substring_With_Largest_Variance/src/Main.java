import java.util.Scanner;

class Solution {
    public int largestVariance(String s) {
        int[] count = new int[26];
        int answer = 0;

        for (char ch : s.toCharArray()) {
            ++count[(ch - 'a')];
        }

        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (i == j || count[i] == 0 || count[j] == 0) continue;
                char major = (char) (i + 'a');
                char minor = (char) (j + 'a');
                int majorCount = 0;
                int minorCount = 0;
                int remainingMinor = count[j];
                for (char ch : s.toCharArray()) {
                    if (ch == major) {
                        ++majorCount;
                    }
                    if (ch == minor) {
                        ++minorCount;
                        --remainingMinor;
                    }
                    if (minorCount > 0) {
                        answer = Math.max(answer, majorCount - minorCount);
                    }
                    if (remainingMinor > 0 && majorCount < minorCount) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
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
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.largestVariance(s));
        }

        sc.close();
    }
}
