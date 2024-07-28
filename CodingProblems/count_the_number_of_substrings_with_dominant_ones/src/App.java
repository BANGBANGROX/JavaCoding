import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int answer = 0;

        for (int requiredZeroesCnt = 1; requiredZeroesCnt * requiredZeroesCnt <= n; ++requiredZeroesCnt) {
            int onesCnt = 0;
            int lastZeroIndex = -1;
            LinkedList<Integer> zeroIndices = new LinkedList<>();
            for (int right = 0; right < n; ++right) {
                if (s.charAt(right) == '0') {
                    zeroIndices.add(right);
                    while (zeroIndices.size() > requiredZeroesCnt) {
                        onesCnt -= (zeroIndices.getFirst() - lastZeroIndex - 1);
                        lastZeroIndex = zeroIndices.pollFirst();
                    }
                } else {
                    ++onesCnt;
                }
                if (zeroIndices.size() == requiredZeroesCnt && onesCnt >= requiredZeroesCnt * requiredZeroesCnt) {
                    answer += Math.min(zeroIndices.getFirst() - lastZeroIndex, onesCnt - requiredZeroesCnt * requiredZeroesCnt + 1);
                }
            }
        }

        int idx = 0;

        while (idx < n) {
            if (s.charAt(idx) == '0') {
                ++idx;
            } else {
                int onesCnt = 0;
                while (idx < n && s.charAt(idx) == '1') {
                    ++idx;
                    ++onesCnt;
                }
                answer += onesCnt * (onesCnt + 1) / 2;
            }
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().numberOfSubstrings(scanner.next()));
        }

        scanner.close();
    }
}
