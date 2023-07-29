//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); }
            }
            return st.nextToken();
        }

        Integer nextInt(){
            return Integer.parseInt(next());
        }

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt(); // Inputting the testcases
        PrintWriter out = new PrintWriter(System.out);
        while (t-- > 0) {

            int i;
            int N = sc.nextInt();

            int[] arr = new int[(int)(N)];

            for (i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            Solution ob = new Solution();
            out.println(ob.countSpecialNumbers(arr));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countSpecialNumbers(int[] nums) {
        // Code here
        HashMap<Integer, Integer> count = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            for (int factor = 1; factor * factor <= num; ++factor) {
                if (num % factor == 0) {
                    int cnt = count.getOrDefault(factor, 0);
                    if (num == factor) {
                        if (cnt > 1) {
                            ++ans;
                            break;
                        }
                    }
                    else {
                        if (cnt > 0) {
                            ++ans;
                            break;
                        }
                    }
                    if (num / factor != factor) {
                        int next = num / factor;
                        if (next == num && count.getOrDefault(num, 0) > 1) {
                            ++ans;
                            break;
                        }
                        else if (next != num && count.getOrDefault(next, 0) > 0) {
                            ++ans;
                            break;
                        }
                    }
                }
            }
        }

        return ans;
    }
}