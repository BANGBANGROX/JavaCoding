//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minLength(s));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minLength(String s) {
        // code here
        String[] dictionary = {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"};
        Stack<Character> st = new Stack<>();
        HashSet<String> dictSet = new HashSet<>(Arrays.asList(dictionary));

        for (char ch: s.toCharArray()) {
            if (st.size() > 1) {
                char ch1 = st.pop();
                char ch2 = st.pop();
                if (!dictSet.contains("" + ch2 + ch1)) {
                    st.push(ch2);
                    st.push(ch1);
                }
            }
            st.push(ch);
        }

        if (st.size() > 1) {
            char ch1 = st.pop();
            char ch2 = st.pop();
            if (!dictSet.contains("" + ch2 + ch1)) {
                st.push(ch2);
                st.push(ch1);
            }
        }

        return st.size();
    }
}