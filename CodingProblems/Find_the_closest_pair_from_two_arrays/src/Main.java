//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while(testcases-- > 0){
            String[] element = br.readLine().split(" ");
            int N = Integer.parseInt(element[0]);
            int M = Integer.parseInt(element[1]);
            int arr [] = new int[N];
            int brr [] = new int[M];
            String[] elements = br.readLine().split(" ");
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(elements[i]);

            String[] ele = br.readLine().split(" ");
            for(int i=0; i<M; i++)
                brr[i] = Integer.parseInt(ele[i]);

            int X = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> ans;
            ans = obj.printClosest(arr, brr, N, M, X);
            System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    public ArrayList<Integer> printClosest(int[] nums1, int[] nums2, int m, int n, int x) {
        // code here
        int l = 0;
        int r = n - 1;
        int first = nums1[l];
        int last = nums2[r];

        while (l < m && r >= 0) {
            int current = nums1[l] + nums2[r];
            int prev = first + last;
            if (Math.abs(x - current) < Math.abs(x - prev)) {
                first = nums1[l];
                last = nums2[r];
            }
            if (current > x) --r;
            else ++l;
        }

        return new ArrayList<>(Arrays.asList(first, last));
    }
}