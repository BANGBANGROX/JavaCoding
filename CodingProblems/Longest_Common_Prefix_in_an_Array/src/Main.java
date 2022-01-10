// { Driver Code Starts
//Initial Template for Java

import java.io.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String[] arr = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String[] arr, int n){
        // code here
        String ans = "";
        String smallestString = arr[0];

        for (int i = 1; i < n; ++i) {
            if (arr[i].length() < smallestString.length()) {
                smallestString = arr[i];
            }
        }

        for (int i = 0; i < smallestString.length(); ++i) {
            String curr = smallestString.substring(0, i + 1);
            boolean matches = true;
            for (int j = 0; j < n; ++j) {
                if (!curr.matches(arr[j].substring(0, i + 1))) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                if (ans.length() < curr.length()) ans = curr;
            }
            else break;
        }

        return ans.length() == 0 ? "-1" : ans;
    }
}