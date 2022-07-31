//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private ArrayList<Long> nums;

    private void generationPossible(int previousDigit, long x, long currentNumber) {
        nums.add(currentNumber);

        if (previousDigit == -1) {
            for (int i = 0; i < 10; ++i) {
                if (currentNumber * 10L + i <= x) {
                    generationPossible(i, x, currentNumber * 10 + i);
                }
            }
        }
        else {
            int possibleDig1 = previousDigit - 1;
            int possibleDig2 = previousDigit + 1;
            if (possibleDig1 >= 0) {
                if (currentNumber * 10 + possibleDig1 <= x) {
                    generationPossible(possibleDig1, x, currentNumber * 10 + possibleDig1);
                }
            }
            if (possibleDig2 < 10) {
                if (currentNumber * 10 + possibleDig2 <= x) {
                    generationPossible(possibleDig2, x, currentNumber * 10 + possibleDig2);
                }
            }
        }

    }

    public long jumpingNums(long x) {
        // code here
        nums = new ArrayList<>();

        generationPossible(-1, x, 0);

        nums.sort((a, b) -> (int) (a - b));

        return nums.get(nums.size() - 1);
    }
};