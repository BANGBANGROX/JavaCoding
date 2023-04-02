//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution {
    private int upperBound(long[] nums, int key) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] > key) r = mid - 1;
            else l = mid + 1;
        }

        return n - l;
    }

    public long printPairs(long[] nums, int k) {
        HashSet<Long> present = new HashSet<>();
        long ans = 0;

        Arrays.sort(nums);

        for (long x : nums) {
            present.add(x);
        }

        for (long num : nums) {
            long temp = num;
            num -= k;
            if (num < 0) continue;
            if (num == 0) {
                ans += upperBound(nums, k);
                continue;
            }
            for (long i = 1; i * i <= num; ++i) {
                if (num % i == 0) {
                    if (present.contains(i) && temp % i == k) {
                        ++ans;
                    }
                    if (num / i != i) {
                        if (present.contains(num / i) && temp % (num / i) == k) {
                            ++ans;
                        }
                    }
                }
            }
        }

        return ans;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long[] a =new long[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.printPairs(a, k);
            System.out.println(ans);
        }
    }
}


//User function Template for Java



// } Driver Code Ends