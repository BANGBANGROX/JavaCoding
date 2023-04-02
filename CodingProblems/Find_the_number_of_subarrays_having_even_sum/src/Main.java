//{ Driver Code Starts
//Initial Template for Java


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            long ans = new Solution().countEvenSum(arr);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java




class Solution {
   public long countEvenSum(int[] nums) {
       // code here
       long evenCount = 0;
       long oddCount = 0;
       long runningSum = 0;

       for (int num : nums) {
           runningSum += num;
           if ((runningSum & 1) > 0) {
               ++oddCount;
           }
           else {
               ++evenCount;
           }
       }

       return evenCount + evenCount * (evenCount - 1) / 2 + oddCount * (oddCount - 1) / 2;
   }
}
