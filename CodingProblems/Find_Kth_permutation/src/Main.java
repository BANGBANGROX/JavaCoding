//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// } Driver Code Ends
class Solution {
    private void reverseArray(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            ++l;
            --r;
        }
    }

    private void nextPermutation(char[] chars) {
        int n = chars.length;
        int last = n - 2;

        while (last >= 0 && chars[last] >= chars[last + 1]) --last;

        int nextGreater = last;

        for (int i = n - 1; i > last; --i) {
            if (chars[i] > chars[last]) {
                nextGreater = i;
                break;
            }
        }

        char temp = chars[last];
        chars[last] = chars[nextGreater];
        chars[nextGreater] = temp;

        reverseArray(chars, last + 1, n - 1);
    }

    public String kthPermutation(int n, int k) {
        // code here
        char[] chars = new char[n];

        for (int i = 0; i < n; ++i) {
            chars[i] = (char)((i - 1) + '0');
        }

        while (k > 1) {
            nextPermutation(chars);
            --k;
        }

        return new String(chars);
    }
}



//{ Driver Code Starts.

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0], a[1]);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends