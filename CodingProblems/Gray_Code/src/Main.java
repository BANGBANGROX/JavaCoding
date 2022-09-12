//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public ArrayList<String> graycode(int n) {
        //code here
        HashSet<String> visited = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        StringBuilder current = new StringBuilder();

        current.append("0".repeat(Math.max(0, n)));

        q.add(current.toString());
        visited.add(current.toString());

        while (!q.isEmpty()) {
            String present = q.poll();
            ans.add(present);
            char[] presentArr = present.toCharArray();
            for (int i = n - 1; i >= 0; --i) {
                if (presentArr[i] == '0') {
                    presentArr[i] = '1';
                    if (!visited.contains(new String(presentArr))) {
                        q.add(new String(presentArr));
                        visited.add(new String(presentArr));
                        break;
                    }
                    presentArr[i] = '0';
                }
                else {
                    presentArr[i] = '0';
                    if (!visited.contains(new String(presentArr))) {
                        q.add(new String(presentArr));
                        visited.add(new String(presentArr));
                        break;
                    }
                    presentArr[i] = '1';
                }
            }
        }

        return ans;
    }
}

//{ Driver Code Starts.

class BitWise
{
    static int n;

    // Driver Code
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); //Inputting the testcases

        while(t>0) //While testcases exist
        {

            n = Integer.parseInt(br.readLine()); //Input N

            Solution obj = new Solution();

            ArrayList<String> ans=obj.graycode(n);
            for (String an : ans) System.out.print(an + " ");

            System.out.println();

            t--;
        }
    }


}

// } Driver Code Ends