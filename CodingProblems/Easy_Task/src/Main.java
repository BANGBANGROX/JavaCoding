//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s = in.readLine().trim();
            int q = Integer.parseInt(in.readLine().trim());
            Query[] a = new Query[q];
            for (int i = 0; i < q; i++) {
                String str = in.readLine().trim();
                String[] st = str.split(" ");
                if (st[0].trim().equals("1")) {
                    a[i] = new Query("1", st[1], st[2], "");
                } else {
                    a[i] = new Query("2", st[1], st[2], st[3]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Character> ans = ob.easyTask(n, s, q, a);
            for (char ch : ans) {
                out.print(ch + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[][] segmentTree;
    private char[] stringCharArray;

    private void buildTree(int idx, int l, int r) {
        if (l == r) {
            ++segmentTree[idx][stringCharArray[l] - 'a'];
            return;
        }

        int mid = (l + ((r - l) >> 1));

        buildTree(2 * idx + 1, l, mid);
        buildTree(2 * idx + 2, mid + 1, r);

        for (int i = 0; i < 26; ++i) {
            segmentTree[idx][i] = segmentTree[2 * idx + 1][i] + segmentTree[2 * idx + 2][i];
        }
    }

    private void updateTree(int idx, int l, int r, int index, char newCharacter) {
        if (l == r) {
            --segmentTree[idx][stringCharArray[l] - 'a'];
            ++segmentTree[idx][newCharacter - 'a'];
            return;
        }

        int mid = (l + ((r - l) >> 1));

        if (index <= mid) {
            updateTree(2 * idx + 1, l, mid, index, newCharacter);
        }
        else {
            updateTree(2 * idx + 2, mid + 1, r, index, newCharacter);
        }

        for (int i = 0; i < 26; ++i) {
            segmentTree[idx][i] = segmentTree[2 * idx + 1][i] + segmentTree[2 * idx + 2][i];
        }
    }

    private int[] queryTree(int idx, int l, int r, int start, int end) {
        if (start > r || end < l) return new int[26];

        if (start <= l && end >= r) return segmentTree[idx];

        int mid = (l + ((r - l) >> 1));
        int[] leftTreeResult = queryTree(2 * idx + 1, l, mid, start, end);
        int[] rightTreeResult = queryTree(2 * idx + 2, mid + 1, r, start, end);
        int[] answer = new int[26];

        for (int i = 0; i < 26; ++i) {
            answer[i] = leftTreeResult[i] + rightTreeResult[i];
        }

        return answer;
    }

    public ArrayList<Character> easyTask(int n, String s, int q, Query[] queries) {
        ArrayList<Character> answer = new ArrayList<>();
        segmentTree = new int[4 * n + 5][26];
        stringCharArray = s.toCharArray();

        buildTree(0, 0, n - 1);

        for (int i = 0; i < q; ++i) {
            String type = queries[i].type;
            if (type.equals("1")) {
                int index = Integer.parseInt(queries[i].a);
                char newCharacter = queries[i].b.charAt(0);
                updateTree(0, 0, n - 1, index, newCharacter);
                stringCharArray[index] = newCharacter;
            }
            else {
                int start = Integer.parseInt(queries[i].a);
                int end = Integer.parseInt(queries[i].b);
                int k = Integer.parseInt(queries[i].c);
                int[] rangeQueryResult = queryTree(0, 0, n - 1, start, end);
                for (int j = 25; j >= 0; --j) {
                    if (rangeQueryResult[j] < k) {
                        k -= rangeQueryResult[j];
                    }
                    else {
                        answer.add((char)(j + 'a'));
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class Query {
    String type;
    String a;
    String b;
    String c;

    public Query(String type, String a, String b, String c) {
        this.type = type;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}