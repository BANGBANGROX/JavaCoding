//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPairs(a, n));

        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    private int merge(int[] nums, int left, int mid, int right) {
        int result = 0;
        int i = 0;
        int j = mid + 1;
        int k = 0;
        int[] newNums = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                newNums[k] = nums[i];
                ++i;
            }
            else {
                newNums[k] = nums[j];
                ++j;
                result += (mid - i + 1);
            }
            ++k;
        }

        while (i <= mid) {
            newNums[k] = nums[i];
            ++i;
            ++k;
        }

        while (j <= right) {
            newNums[k] = nums[j];
            ++j;
            ++k;
        }

        for (i = left; i <= right; ++i) {
            nums[i] = newNums[i - left];
        }

        return result;
    }

    private int mergeSort(int[] nums, int left, int right) {
        int result = 0;

        if (left < right) {
            int mid = (left + right) / 2;
            result += mergeSort(nums, left, mid);
            result += mergeSort(nums, mid + 1, right);
            result += merge(nums, left, mid, right);
        }

        return result;
    }

    private int countInversions(int[] nums, int n) {
        return mergeSort(nums, 0, n - 1);
    }

    public int countPairs(int[] nums, int n) {
        // Your code goes here
        for (int i = 0; i < n; ++i) {
            nums[i] *= i;
        }

        return countInversions(nums, n);
    }
}
