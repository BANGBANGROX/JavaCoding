//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                    " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                    " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res;
            res = obj.findUnion(a, b);
            for (Integer re : res) System.out.print(re + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public ArrayList<Integer> findUnion(int[] a, int[] b) {
        // add your code here
        ArrayList<Integer> answer = new ArrayList<>();
        int m = a.length;
        int n = b.length;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (a[i] == b[j]) {
                answer.add(a[i]);
                ++i;
                ++j;
            } else if (a[i] < b[j]) {
                answer.add(a[i]);
                ++i;
            } else {
                answer.add(b[j]);
                ++j;
            }
        }

        while (i < m) {
            answer.add(a[i]);
            ++i;
        }

        while (j < n) {
            answer.add(b[j]);
            ++j;
        }

        return answer;
    }
}
