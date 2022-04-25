import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int n = inventory.length;
        long ans = 0;
        final int mod = (int)1e9 + 7;

        Arrays.sort(inventory);

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int temp = inventory[l];
            inventory[l] = inventory[r];
            inventory[r] = temp;
            ++l;
            --r;
        }

        for (int i = 0; i < n;) {
            int columns = i + 1;
            while (columns < n && inventory[columns] == inventory[i]) ++columns;
            long current = inventory[i];
            long next = (columns < n ? inventory[columns] : 0);
            long terms = Math.min((long) columns * (current - next), orders);
            long rows = terms / columns;
            long left = terms % columns;
            long sum = ((((2 * current - rows + 1) * rows) / 2 * columns) % mod + (current - rows) * left) % mod;
            ans = (ans + sum) % mod;
            i = columns;
            orders -= terms;
            if (orders == 0) break;
        }

        return (int) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] inventory = new int[n];
            for (int i = 0; i < n; ++i) {
                inventory[i] = sc.nextInt();
            }
            int orders = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maxProfit(inventory, orders));
        }

        sc.close();
    }
}
