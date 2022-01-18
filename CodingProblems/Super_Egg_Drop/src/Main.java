import java.util.Scanner;

class Solution {
    private boolean checkSteps(int x, int n, int k) {
        int sum = 0;
        int product = 1;

        for (int i = 1; i <= n; ++i) {
            product *= (x - i + 1);
            product /= i;
            sum += product;
            if (sum >= k) return true;
        }

        return false;
    }

    public int superEggDrop(int n, int k) {
        int low = 1;
        int high = k;

        while (low < high) {
            int mid = (low + ((high - low) >> 1));
            if (checkSteps(mid, n, k)) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.superEggDrop(n, k));
        }

        sc.close();
    }
}
