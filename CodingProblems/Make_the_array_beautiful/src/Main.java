//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {

        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.makeBeautiful(arr);
            for (int e : res) out.print(e + " ");
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> makeBeautiful(int[] nums) {
        // code here
        LinkedList<Integer> ls = new LinkedList<>();
        int n = nums.length;

        ls.add(nums[0]);

        for (int i = 1; i < n; ++i) {
            if (ls.isEmpty()) ls.add(nums[i]);
            else {
                int x = ls.getLast();
                int y = nums[i];
                if ((x >= 0 && y < 0) || (x < 0 && y >= 0)) {
                    ls.pollLast();
                }
                else ls.add(y);
            }
        }

        return new ArrayList<>(ls);
    }
}
