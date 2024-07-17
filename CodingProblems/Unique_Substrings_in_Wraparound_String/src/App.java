import java.util.Scanner;

class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] count = new int[26];
        int answer = 0;
        int n = s.length();
        int currentCnt = 1;
        
        count[s.charAt(0) - 'a'] = 1;

        for (int i = 1; i < n; ++i) {
            int diff = s.charAt(i) - s.charAt(i - 1);
            if (diff == 1 || diff == -25) {
                ++currentCnt;
            } else {
                currentCnt = 1;
            }
            int idx = s.charAt(i) - 'a';
            count[idx] = Math.max(count[idx], currentCnt);
        }

        for (int x : count) {
            answer += x;
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            System.out.println(new Solution().findSubstringInWraproundString(scanner.next()));
        }

        scanner.close();
    }
}
