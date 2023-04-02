//{ Driver Code Starts





import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public ArrayList<Integer> kTop(int[] nums, int n, int k) {
        //code here.
        ArrayList<Integer> ans = new ArrayList<>();
        TreeSet<ArrayList<Integer>> st = new TreeSet<>((a, b) ->
                !Objects.equals(a.get(0), b.get(0)) ? a.get(0) - b.get(0) : b.get(1) - a.get(1));
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            int cnt = count.getOrDefault(num, 0);
            ArrayList<Integer> previous = new ArrayList<>(Arrays.asList(cnt, num));
            st.remove(previous);
            ArrayList<Integer> next = new ArrayList<>(Arrays.asList(cnt + 1, num));
            count.put(num, cnt + 1);
            if (st.size() < k) {
                st.add(next);
            }
            else {
                ArrayList<Integer> top = st.first();
                if (top.get(0) < cnt + 1) {
                    st.remove(top);
                    st.add(next);
                }
                else if (top.get(0) == cnt + 1) {
                    if (top.get(1) > num) {
                        st.remove(top);
                        st.add(next);
                    }
                }
            }
            ArrayList<Integer> currentList = new ArrayList<>();
            for (ArrayList<Integer> x : st) {
                currentList.add(x.get(1));
            }
            Collections.reverse(currentList);
            ans.addAll(currentList);
        }

        return ans;
    }
}


//{ Driver Code Starts.

// Driver class
public class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line1 = br.readLine();
            String[] ele = line1.trim().split("\\s+");
            int n = Integer.parseInt(ele[0]);
            int k = Integer.parseInt(ele[1]);
            String line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(elements[i]);
            Solution ob = new Solution();
            ArrayList<Integer> ans;
            //   System.out.println(a[0]+" "+n+" "+k);
            ans = ob.kTop(a, n, k);
            for (Integer an : ans) {
                System.out.print(an + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends