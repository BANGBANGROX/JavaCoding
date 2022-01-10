import java.util.Scanner;

class Solution {
    public int trap(int[] height) {
       int n = height.length;
       int l = 0;
       int r = n - 1;
       int leftHeight = height[l];
       int rightHeight = height[r];
       int ans = 0;

       while (l < r) {
           leftHeight = Math.max(leftHeight, height[l]);
           rightHeight = Math.max(rightHeight, height[r]);
           if (leftHeight < rightHeight) {
               ans += (leftHeight - height[l]);
               ++l;
           }
           else {
               ans += (rightHeight - height[r]);
               --r;
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
            int[] height = new int[n];
            for (int i = 0; i < n; ++i) height[i] = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.trap(height));
        }

        sc.close();
    }
}
