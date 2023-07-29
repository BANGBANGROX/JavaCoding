//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> arr = new ArrayList<>(n);
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(inputLine[i]));
            }

            Solution ob = new Solution();

            System.out.println(ob.rotateDelete(arr, n));

        }
    }
}


// } Driver Code Ends



class Solution {

    // function to do operations of rotate and delete
    // nums: input array
    // n: size of Array
    public int rotateDelete(ArrayList<Integer> nums, int n) {
        // Your code here
        if (n == 1) return nums.get(0);

        if ((n & 1) > 0) {
            return nums.get(((n - 3) / 4 + 2));
        }

        return nums.get(((n - 2) / 4 + 1));
    }

}