import java.util.Scanner;

class Solution {
    private int[] quantities;
    private int n;

    private boolean check(int val) {
        int itr = 0;
        int m = quantities.length;
        int current = quantities[itr];

        for (int i = 0; i < n; ++i) {
            current -= val;
            if (current <= 0) {
                ++itr;
                if (itr >= m) return true;
                current = quantities[itr];
            }
        }

        return false;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        this.n = n;
        this.quantities = quantities;
        int left = 1;
        int right = (int) 1e9;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
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
           int n = scanner.nextInt();
           int m = scanner.nextInt();
           int[] quantities = new int[m];
           for (int i = 0; i < m; ++i) {
               quantities[i] = scanner.nextInt();
           }

           System.out.println(new Solution().minimizedMaximum(n, quantities));
       }
       
       scanner.close();
   }
}
