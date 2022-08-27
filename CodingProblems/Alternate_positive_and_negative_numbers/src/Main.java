//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int[] nums) {
        // code here
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int num: nums) {
            if (num < 0) negative.add(num);
            else positive.add(num);
        }

        int i = 0;
        int j = 0;
        int k = 0;
        boolean positiveOrNegative = true;

        while (i < positive.size() && j < negative.size()) {
            if (positiveOrNegative) {
                nums[k] = positive.get(i);
                ++i;
            }
            else {
                nums[k] = negative.get(j);
                ++j;
            }
            ++k;
            positiveOrNegative = !positiveOrNegative;
        }

        while (i < positive.size()) {
            nums[k] = positive.get(i);
            ++i;
            ++k;
        }

        while (j < negative.size()) {
            nums[k] = negative.get(j);
            ++j;
            ++k;
        }
    }
}