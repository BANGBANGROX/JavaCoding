//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String[] S = read.readLine().split(" ");
            int[] A = new int[N];

            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            int[] ptr = ob.satisfyEqn(A,N);

            System.out.println(ptr[0] + " " + ptr[1] + " " + ptr[2] + " " + ptr[3]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] satisfyEqn(int[] nums, int n) {
        // code here
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        int[] ans = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = nums[i] + nums[j];
                if (mp.containsKey(sum)) {
                    int a = mp.get(sum).get(0);
                    int b = mp.get(sum).get(1);
                    if (i != a && i != b && j != a && j != b) {
                        int[] current = {a, b, i, j};
                        boolean res = false;
                        for (int k = 0; k < 4; ++k) {
                            if (current[k] < ans[k]) {
                                res = true;
                                break;
                            } else if (ans[k] < current[k]) break;
                        }
                        if (res) ans = current.clone();
                    }
                }
                else {
                    mp.put(sum, new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        if (ans[0] == Integer.MAX_VALUE) return new int[]{-1, -1, -1, -1};

        return ans;
    }
}