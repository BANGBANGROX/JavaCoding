import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
         int n = time.length;
         int maxValue = Arrays.stream(time).max().getAsInt();
         int ans = 0;
         int[] frequency = new int[maxValue + 1];

         for (int i = 0; i < n; ++i) {
             ++frequency[time[i]];
         }

         for (int i = 0; i < n; ++i) {
             if (frequency[time[i]] == 0) continue;
             int start = (time[i] / 60 + 1) * 60 - time[i];
             for (int j = start; j <= maxValue; j += 60) {
                 if (j == time[i]) {
                     ans += (frequency[time[i]] * (frequency[time[i]] - 1)) / 2;
                 }
                 else {
                     ans += frequency[j] * frequency[time[i]];
                 }
             }
             frequency[time[i]] = 0;
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
            int[] time = new int[n];
            for (int i = 0; i < n; ++i) time[i] = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.numPairsDivisibleBy60(time));
        }

        sc.close();
    }
}
