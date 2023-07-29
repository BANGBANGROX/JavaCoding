//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n;
            n = Integer.parseInt(br.readLine());


            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.dominantPairs(n, arr);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public int dominantPairs(int n, int[] nums) {
        // code here
        ArrayList<Integer> firstHalf = new ArrayList<>();
        ArrayList<Integer> secondHalf = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (i < n / 2) {
                firstHalf.add(nums[i]);
            }
            else {
                secondHalf.add(5 * nums[i]);
            }
        }

        Collections.sort(firstHalf);
        Collections.sort(secondHalf);
        Collections.reverse(secondHalf);

        int l = firstHalf.size() - 1;
        int r = 0;
        int ans = 0;

        while (l >= 0 && r < secondHalf.size()) {
            int x = firstHalf.get(l);
            int y = secondHalf.get(r);
            if (x >= y) {
                ans += (secondHalf.size() - r);
                --l;
            }
            else ++r;
        }

        return ans;
    }
}

