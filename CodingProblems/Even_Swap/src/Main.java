//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int [] arr = new int[n];
            String [] str = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution obj = new Solution();
            int [] b = obj.lexicographicallyLargest(arr, n);
            for(int x: b) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int[] lexicographicallyLargest(int[] nums, int n) {
        //Write your code here
        for (int i = 0; i + 1 < n;) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    if (i > 0) --i;
                }
                else ++i;
            }
            else ++i;
        }

        return nums;
    }
}