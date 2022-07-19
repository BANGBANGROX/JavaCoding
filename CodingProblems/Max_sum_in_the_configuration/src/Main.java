//{ Driver Code Starts
import java.util.*;

public class Main
{
    public  static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();

            System.out.println(new GfG().max_sum(arr,n));

            t--;
        }
    }

}

// } Driver Code Ends


class GfG {
    int max_sum(int nums[], int n) {
        // Your code here
        int currentSum = 0;
        int initialResult = 0;

        for (int i = 0; i < n; ++i) {
            currentSum += nums[i];
            initialResult += i * nums[i];
        }

        int ans = initialResult;

        for (int i = 0; i < n; ++i) {
            initialResult = (initialResult - (currentSum - nums[i]) + nums[i] * (n - 1));
            ans = Math.max(ans, initialResult);
        }

        return ans;
    }
}
