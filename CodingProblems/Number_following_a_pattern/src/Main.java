//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public String printMinNumberForPattern(String s) {
        // code here
        Stack<Integer> st = new Stack<>();
        int currentNum = 1;
        int n = s.length();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            st.push(currentNum);
            ++currentNum;
            if (s.charAt(i) == 'I') {
                while (!st.isEmpty()) {
                    answer.append(st.pop());
                }
            }
        }

        st.push(currentNum);

        while (!st.isEmpty()) {
            answer.append(st.pop());
        }

        return answer.toString();
    }
}
