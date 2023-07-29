// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n,m,i;
            n = sc.nextInt();
            m = sc.nextInt();
            int arr[] = new int[n];
            for(i=0;i<n;i++)
                arr[i]=sc.nextInt();
            Sol obj = new Sol();
            System.out.println(obj.diffSum(n,m,arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Sol {
    private void descendingOrderSort(int[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            ++l;
            --r;
        }
    }

    public int diffSum(int n, int m, int[] strengths) {
        //code here.
        descendingOrderSort(strengths);

        long firstGroupSum = 0;
        long secondGroupSum = 0;
        int secondGroupStart = (n - m);

        for (int i = 0; i < m; ++i) {
            firstGroupSum += strengths[i];
        }

        for (int i = secondGroupStart; i < n; ++i) {
            secondGroupSum += strengths[i];
        }

        return (int) (firstGroupSum - secondGroupSum);
    }
}