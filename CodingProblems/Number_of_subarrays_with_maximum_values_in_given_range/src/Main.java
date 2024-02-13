//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        while(testcases-- > 0){

            String line1 = br.readLine();
            String []element = line1.trim().split(" ");
            int n = Integer.parseInt(element[0]);
            int l = Integer.parseInt(element[1]);
            int r = Integer.parseInt(element[2]);

            int arr[] = new int[n];


            String line = br.readLine();
            String[] elements = line.trim().split(" ");

            for(int index = 0;index < n; index++){
                arr[index] = Integer.parseInt(elements[index]);
            }

            Solution obj = new Solution();

            System.out.println(obj.countSubarrays(arr, n, l, r));

        }

    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    private long countSubarraysUtil(int[] nums, int n, int key) {
        long answer = 0;
        int maxValue = Integer.MIN_VALUE;
        int l = 0;

        for (int r = 0; r < n; ++r) {
            maxValue = Math.max(maxValue, nums[r]);
            if (maxValue > key) {
                maxValue = Integer.MIN_VALUE;
                l = r + 1;
            }
            answer += (r - l + 1);
        }

        return answer;
    }

    public long countSubarrays(int[] nums, int n, int l, int r) {
        // Complete the function
        return countSubarraysUtil(nums, n, r) - countSubarraysUtil(nums, n, l - 1);
    }
}

