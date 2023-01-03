import java.util.Scanner;

class Solution {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int previousEmpty = -1;
        int previousFort = -1;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (forts[i] == -1) {
                if (previousFort != -1 && previousFort > previousEmpty) {
                    ans = Math.max(ans, i - previousFort - 1);
                }
                previousEmpty = i;
            }
            else if (forts[i] == 1) {
                if (previousEmpty != -1 && previousEmpty > previousFort) {
                    ans = Math.max(ans, i - previousEmpty - 1);
                }
                previousFort = i;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] forts = new int[n];
            for (int i = 0; i < n; ++i) {
                forts[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.captureForts(forts));
        }

        sc.close();
    }
}
