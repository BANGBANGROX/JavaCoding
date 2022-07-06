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

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n;
            n = Integer.parseInt(br.readLine());


            int[] A = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minSwaps(n, A);

            System.out.println(res);

        }
    }
}
// } Driver Code Ends


class Solution {
    private int[] inorder;
    private int ind;

    private void inorderTraversal(int[] tree, int index) {
         if (index >= tree.length) return;

         inorderTraversal(tree, 2 * index + 1);

         inorder[++ind] = tree[index];

         inorderTraversal(tree, 2 * index + 2);
    }

    public int minSwaps(int n, int[] tree) {
        // code here
        inorder = new int[n];
        ind = -1;

        inorderTraversal(tree, 0);

        ArrayList<ArrayList<Integer>> numsWithIndex = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            numsWithIndex.add(new ArrayList<>(Arrays.asList(inorder[i], i)));
        }

        numsWithIndex.sort(Comparator.comparingInt(a -> a.get(0)));

        for (int i = 0; i < n; ++i) {
            if (numsWithIndex.get(i).get(1) == i) continue;
            ++ans;
            ArrayList<Integer> x = numsWithIndex.get(i);
            int index = numsWithIndex.get(i).get(1);
            ArrayList<Integer> y = numsWithIndex.get(index);
            numsWithIndex.set(i, y);
            numsWithIndex.set(index, x);
            --i;
        }

        return ans;
    }
}

