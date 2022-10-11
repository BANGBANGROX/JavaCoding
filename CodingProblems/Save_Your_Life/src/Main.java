//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution {
    public String maxSum(String s, char[] x, int[] b, int n) {
        //code here
        HashMap<Character, Integer> asciiMap = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            asciiMap.put(x[i], b[i]);
        }

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (!asciiMap.containsKey(ch)) {
                asciiMap.put(ch, (int) ch);
            }
        }

        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            if (!asciiMap.containsKey(ch)) {
                asciiMap.put(ch, (int) ch);
            }
        }

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int endIndex = -1;
        int len = s.length();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < len; ++i) {
            currentSum = Math.max(currentSum + asciiMap.get(s.charAt(i)),
                    asciiMap.get(s.charAt(i)));
            if (maxSum < currentSum) {
                maxSum = currentSum;
                endIndex = i;
            }
        }

        if (maxSum <= 0) {
            return "" + s.charAt(endIndex);
        }

        while (maxSum > 0) {
            maxSum -= asciiMap.get(s.charAt(endIndex));
            ans.append(s.charAt(endIndex));
            --endIndex;
        }

        ans.reverse();

        return ans.toString();
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String[] TE = read.readLine().trim().split(" ");
            char[] x = new char[n];
            for (int i = 0; i < n; i++) {
                x[i] = TE[i].charAt(0);
            }

            String[] TR = read.readLine().trim().split(" ");
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(TR[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxSum(w, x, b, n));
        }
    }
}
// } Driver Code Ends