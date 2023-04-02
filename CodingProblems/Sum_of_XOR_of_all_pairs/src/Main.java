//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);

            int[] arr = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }


            Solution obj = new Solution();
            long res = obj.sumXOR(arr, sizeOfArray);
            System.out.println(res);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    public long sumXOR(int[] nums, int n) {
        //Complete the function
        long ans = 0;

        for (int i = 31; i >= 0; --i) {
            int setBitCount = 0;
            for (int num : nums) {
                if ((num & (1 << i)) > 0) {
                    ++setBitCount;
                }
            }
            ans += ((long) setBitCount * (n - setBitCount) * (1L << i));
        }

        return ans;
    }
}


