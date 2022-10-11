//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;

// Position this line where user code will be pasted.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input;
            input = read.readLine().split(" ");
            String S = input[0];
            int k = Integer.parseInt(input[1]);
            Solution ob = new Solution();

            System.out.println(ob.lexicographicallySmallest(S, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public String lexicographicallySmallest(String s, int k) {
        // code here
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        double val = Math.log10(n) / Math.log10(2);

        if (val == Math.floor(val)) k /= 2;
        else k *= 2;

        if (k > n) return "-1";

        for (char ch: s.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > ch) {
                st.pop();
                --k;
            }
            st.push(ch);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            --k;
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        return ans.toString().isEmpty() ? "-1" : ans.toString();
    }
}