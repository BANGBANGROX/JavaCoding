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
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(Dictionary,Pattern);
            for(String u:ans)
                System.out.print(u+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public ArrayList<String> CamelCase(String[] dictionary, String pattern) {
        //code here
        ArrayList<String> ans = new ArrayList<>();

        for (String word : dictionary) {
            int i = 0;
            while (i < word.length() && Character.isLowerCase(word.charAt(i))) {
                ++i;
            }
            boolean poss = true;
            for (char ch : pattern.toCharArray()) {
                if (i == word.length() || ch != word.charAt(i)) {
                    poss = false;
                    break;
                }
                ++i;
                while (i < word.length() && Character.isLowerCase(word.charAt(i))) {
                    ++i;
                }
            }
            if (poss) ans.add(word);
        }

        Collections.sort(ans);

        return ans;
    }
}