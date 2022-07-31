import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> s = new Stack<>();
         int n = asteroids.length;

         s.push(asteroids[0]);

         for (int i = 1; i < n; ++i) {
             boolean flag = false;
             while (!s.empty() && s.peek() > 0 && asteroids[i] < 0) {
                 int positiveValue = s.peek();
                 int negativeValue = -1 * asteroids[i];
                 if (positiveValue == negativeValue) {
                     flag = true;
                     s.pop();
                     break;
                 }
                 if (positiveValue > negativeValue) {
                     flag = true;
                     break;
                 }
                 else s.pop();
             }
             if (!flag) s.push(asteroids[i]);
         }

         if (s.empty()) return new int[]{};

         int[] ans = new int[s.size()];
         int ptr = 0;

         while (!s.empty()) {
             ans[ptr] = s.pop();
             ++ptr;
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
            int[] asteroids = new int[n];
            for (int i = 0; i < n; ++i) {
                asteroids[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.asteroidCollision(asteroids);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
