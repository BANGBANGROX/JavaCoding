// { Driver Code Starts
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

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n;
            n = Integer.parseInt(br.readLine());


            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.magicalSubarrays(n, arr);

            System.out.println(res);

        }
    }
}
// } Driver Code Ends


class Solution {
    public long magicalSubarrays(int n, int[] nums) {
        // code here
        long count = 0;
        long ans = 0;
        long evenTotal = 0;
        long oddTotal = 0;
        HashMap<Long, Long> evenCount = new HashMap<>();
        HashMap<Long, Long> oddCount = new HashMap<>();

        for (int num : nums) {
            if ((num & 1) > 0) {
                ++count;
            }
            if ((count & 1) > 0) {
                oddCount.put(count, oddCount.getOrDefault(count, 0L) + 1);
            }
            else {
                evenCount.put(count, evenCount.getOrDefault(count, 0L) + 1);
            }
        }

        for (long x : evenCount.keySet()) {
            long val = evenCount.get(x);
            evenTotal += val;
            ans -= val * (val - 1) / 2;
            if (x > 0) ans += val;
        }

        for (long x : oddCount.keySet()) {
            long val = oddCount.get(x);
            oddTotal += val;
            ans -= val * (val - 1) / 2;
        }

        ans += evenTotal * (evenTotal - 1) / 2;
        ans += oddTotal * (oddTotal - 1) / 2;

        return ans;
    }
}

