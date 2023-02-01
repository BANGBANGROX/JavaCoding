//{ Driver Code Starts
//Initial Template for Java

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            ArrayList<ArrayList<Integer>> res = new Solution().binTreeSortedLevels(arr, n);

            for (ArrayList<Integer> re : res) {
                for (Integer integer : re) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
        }

    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> binTreeSortedLevels(int[] nums, int n) {
        // your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int numberOfNodes = 1;
        int i = 0;

        while (i < n) {
            ArrayList<Integer> currentLevel = new ArrayList<>();
            int nextNodes = numberOfNodes * 2;
            while (i < n && numberOfNodes > 0) {
                currentLevel.add(nums[i]);
                ++i;
                --numberOfNodes;
            }
            numberOfNodes = nextNodes;
            Collections.sort(currentLevel);
            ans.add(new ArrayList<>(currentLevel));
        }

        return ans;
    }
}