//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            obj.Rearrange(a, n);

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++)
                output.append(a[i]).append(" ");
            System.out.println(output);

        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public void Rearrange(int[] nums, int n) {
        // Your code goes here
        ArrayList<Integer> positiveNums = new ArrayList<>();
        ArrayList<Integer> negativeNums = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) negativeNums.add(nums[i]);
            else positiveNums.add(nums[i]);
        }

        for (int i = 0; i < n; ++i) {
            if (ptr1 < negativeNums.size()) {
                nums[i] = negativeNums.get(ptr1);
                ++ptr1;
            }
            else {
                nums[i] = positiveNums.get(ptr2);
                ++ptr2;
            }
        }
    }
}