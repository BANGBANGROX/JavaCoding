import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    public int nthUglyNumber(int n) {
       List<Integer> dp = new ArrayList<>();

       int twoIndex = 0;
       int threeIndex = 0;
       int fiveIndex = 0;

       dp.add(1);

       for (int i = 1; i < n; ++i) {
           int two = dp.get(twoIndex);
           int three = dp.get(threeIndex);
           int five = dp.get(fiveIndex);
           int value = Math.min(2 * two, Math.min(3 * three, 5 * five));
           if (value == 2 * two) ++twoIndex;
           if (value == 3 * three) ++threeIndex;
           if (value == 5 * five) ++fiveIndex;
           dp.add(value);
       }

       return dp.get(n - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.nthUglyNumber(n));
        }

        sc.close();
    }
}
