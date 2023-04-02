import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int ans = 0;
        int[] indexedDiff = new int[n];

        for (int i = 0; i < n; ++i) {
            indexedDiff[i] = reward1[i] - reward2[i];
            ans += reward2[i];
        }

        Arrays.sort(indexedDiff);

        int idx = n - 1;

        while (k > 0) {
            ans += indexedDiff[idx];
            --idx;
            --k;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
