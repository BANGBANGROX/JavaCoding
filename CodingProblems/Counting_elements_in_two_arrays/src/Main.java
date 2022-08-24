//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int arr1[] = new int[m];
            int arr2[] = new int[n];

            for(int i = 0; i < m; i++)
                arr1[i] = sc.nextInt();

            for(int i = 0; i < n; i++)
                arr2[i] = sc.nextInt();

            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }

    }
}
// } Driver Code Ends


// Complete the function given below
class Solution {
    private int upperBound(int[] nums, int n, int key) {
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] <= key) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    public ArrayList<Integer> countEleLessThanOrEqual(int[] nums1, int[] nums2,
                                                             int m, int n) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(nums2);

        for (int num: nums1) {
            ans.add(upperBound(nums2, n, num));
        }

        return ans;
    }
}