import java.util.Scanner;

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int[] whiteCount = new int[n];
        int left = 0;
        int right = k - 1;
        int answer = k;

        whiteCount[0] = (blocks.charAt(0) == 'W' ? 1 : 0);

        for (int i = 1; i < n; ++i) {
            whiteCount[i] = whiteCount[i - 1];
            if (blocks.charAt(i) == 'W') {
                ++whiteCount[i];
            }
        }

        while (right < n) {
            int changes = (whiteCount[right] - (left > 0 ? whiteCount[left - 1] : 0));
            answer = Math.min(answer, changes);
            ++left;
            ++right;
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().minimumRecolors(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
