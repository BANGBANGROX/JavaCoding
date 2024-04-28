//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            String l = br.readLine();
            String[] sarr = l.split(" ");
            int[] arr = new int[sarr.length];
            for(int i1=0;i1<arr.length;i1++){
                arr[i1] = Integer.parseInt(sarr[i1]);
            }

            Solution obj = new Solution();

            int[] res = obj.twoRepeated(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution {
    //Function to find two repeated elements.
    public int[] twoRepeated(int[] nums, int n) {
        // Your code here
        int[] answer = new int[2];
        int cnt = 0;

        for (int i = 0; i < n + 2; ++i) {
            int num = Math.abs(nums[i]);
            if (nums[num] < 0) {
                answer[cnt] = num;
                ++cnt;
            }
            else {
                nums[num] *= -1;
            }
        }

        return answer;
    }
}