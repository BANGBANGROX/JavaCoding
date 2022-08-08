//{ Driver Code Starts
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] a =new  int[n];
            for(int i=0;i<n;i++)
            {
                a[i] = sc.nextInt();
            }
            GfG g = new GfG();
            System.out.println(g.maxCoins(a,n));

        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    private int[][] dp;

    private int maxCoinsUtil(int l, int r, int[] nums) {
         if (l > r) return 0;

         if (l == r) return nums[l];

         if (dp[l][r] != Integer.MAX_VALUE) return dp[l][r];

         int val1 = nums[l] - maxCoinsUtil(l + 1, r, nums);
         int val2 = nums[r] - maxCoinsUtil(l, r - 1, nums);

         return dp[l][r] = Math.max(val1, val2);
    }

    public int maxCoins(int[] nums,int n) {
        //add code here.
        int totalSum = Arrays.stream(nums).sum();
        dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int difference = maxCoinsUtil(0, n - 1, nums);

        return (totalSum + difference) / 2;
    }
}