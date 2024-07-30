import java.util.Scanner;

class Solution {
    public int minimumDeletions(String s) {
        int answer = 0;
        int bCnt = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                ++answer;
                answer = Math.min(answer, bCnt);
            } else {
                ++bCnt;
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
            System.out.println(new Solution().minimumDeletions(scanner.next()));
        }

        scanner.close();
    }
}
