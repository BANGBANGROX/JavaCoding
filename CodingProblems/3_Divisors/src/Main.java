//{ Driver Code Starts
//Initial Template for Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for (int i = 0; i < q; i++) {
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.threeDivisors(query);
            for (int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    private int lowerBound(ArrayList<Long> nums, long key) {
        int l = 0;
        int r = nums.size() - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums.get(mid) > key) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }

    public ArrayList<Integer> threeDivisors(ArrayList<Long> queries) {
        // code here
        final int MAX_N = (int) 1e6 + 5;
        boolean[] isPrime = new boolean[MAX_N];
        ArrayList<Long> primes = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.fill(isPrime, true);

        for (int i = 2; i < MAX_N; ++i) {
            if (isPrime[i]) {
                primes.add((long) i * i);
                for (int j = 2 * i; j < MAX_N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (long query : queries) {
            int res = lowerBound(primes, query);
            ans.add(res);
        }

        return ans;
    }
}