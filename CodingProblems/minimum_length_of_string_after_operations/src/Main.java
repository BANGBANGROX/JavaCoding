import java.util.Scanner;

class Solution {
    public int minimumLength(String s) {
        int[] count = new int[26];
        int answer = 0;

        for (char ch : s.toCharArray()) {
            ++count[ch - 'a'];
        }

        for (int cnt : count) {
            if (cnt > 0) {
                if ((cnt & 1) > 0) {
                    ++answer;
                } else {
                    answer += 2;
                }
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().minimumLength(scanner.next()));
       }
       
       scanner.close();
   }
}
