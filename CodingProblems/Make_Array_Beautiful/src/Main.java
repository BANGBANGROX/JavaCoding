// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] a = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            ot.println(new Solution().minimumOperations(n, a));
        }

        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minimumOperations(int n, int[] nums){
        // Code Here.
        HashMap<Integer, LinkedList<Integer>> remainderNums = new HashMap<>();
        int ans = 0;

        remainderNums.put(0, new LinkedList<>());
        remainderNums.put(1, new LinkedList<>());
        remainderNums.put(2, new LinkedList<>());

        for (int num : nums) {
            remainderNums.get(num % 3).add(num);
        }

        while (!remainderNums.get(1).isEmpty() || !remainderNums.get(2).isEmpty()) {
            if (!remainderNums.get(1).isEmpty() && !remainderNums.get(2).isEmpty()) {
                int x = remainderNums.get(1).pollLast();
                int y = remainderNums.get(2).pollLast();
                remainderNums.get(0).add(x + y);
            }
            else if (remainderNums.get(1).size() > 0) {
                if (remainderNums.get(1).size() == 1) return -1;
                int x = remainderNums.get(1).pollLast();
                int y = remainderNums.get(1).pollLast();
                remainderNums.get(2).add(x + y);
            }
            else {
                if (remainderNums.get(2).size() == 1) return -1;
                int x = remainderNums.get(2).pollLast();
                int y = remainderNums.get(2).pollLast();
                remainderNums.get(1).add(x + y);
            }
            ++ans;
        }

        return ans;
    }
}
