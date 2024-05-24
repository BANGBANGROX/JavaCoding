//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

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
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] nums, int n, int k, int x) {
        // code here
        PriorityQueue<int[]> diffAndNum = new PriorityQueue<>((a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
        int[] answer = new int[k];
        int itr = k - 1;

        for (int num : nums) {
            if (num != x) {
                int diff = Math.abs(num - x);
                if (diffAndNum.size() < k) {
                    diffAndNum.add(new int[]{num, diff});
                }
                else {
                    int[] top = diffAndNum.poll();
                    assert top != null;
                    if (diff < top[1] || (diff == top[1] && num > top[0])) {
                        diffAndNum.add(new int[]{num, diff});
                    }
                    else {
                        diffAndNum.add(top);
                    }
                }
            }
        }

        while (!diffAndNum.isEmpty()) {
            answer[itr] = diffAndNum.poll()[0];
            --itr;
        }

        return answer;
    }
}
