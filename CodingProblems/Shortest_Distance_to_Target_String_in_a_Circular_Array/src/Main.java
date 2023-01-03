import java.util.Scanner;

class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        int n = words.length;

        if (words[startIndex].equals(target)) return 0;

        for (int i = 0; i < n; ++i) {
            if (words[i].equals(target)) {
                int distance1;
                int distance2;
                if (startIndex < i) {
                    distance1 = i - startIndex;
                    distance2 = startIndex + n - i;
                }
                else {
                    distance1 = startIndex - i;
                    distance2 = n - startIndex + i;
                }
                ans = Math.min(ans, Math.min(distance1, distance2));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; ++i) {
                words[i] = sc.next();
            }
            String target = sc.next();
            int startIndex = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.closetTarget(words, target, startIndex));
        }

        sc.close();
    }
}
