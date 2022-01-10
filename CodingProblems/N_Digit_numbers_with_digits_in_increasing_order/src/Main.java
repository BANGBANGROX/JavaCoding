// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.increasingNumbers(N);
            for(int num : ans){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private int maxLen;
    private ArrayList<Integer> ans = new ArrayList<>();

    private void increasingNumbersUtil(int currLen, int previousDigit, String currNumber) {
        if (currLen == maxLen) {
            ans.add(Integer.parseInt(currNumber));
            return;
        }

        for (int i = previousDigit + 1; i < 10; ++i) {
            String prevNumber = currNumber;
            currNumber += String.valueOf(i);
            increasingNumbersUtil(currLen + 1, i, currNumber);
            currNumber = prevNumber;
        }
    }

    public ArrayList<Integer> increasingNumbers(int n){
        // code here
        maxLen = n;

        if (n == 1) {
            for (int i = 0; i < 10; ++i) {
                ans.add(i);
            }

            return ans;
        }

        String currNumber = "";
        increasingNumbersUtil(0, 0, currNumber);

        return ans;
    }
}
