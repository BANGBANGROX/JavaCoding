//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Tree{
    int data;
    Tree left,right,random;
    Tree(int d){
        data=d;
        left=null;
        right=null;
        random=null;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        int n,n1,n2;
        char lr;
        Tree root;
        while(q-->0){
            n=sc.nextInt();
            root=null;
            Solution g=new Solution();
            while(n-->0){
                n1=sc.nextInt();
                n2=sc.nextInt();
                lr=sc.next().charAt(0);
                if(root==null){
                    root=new Tree(n1);
                    switch (lr) {
                        case 'L' -> root.left = new Tree(n2);
                        case 'R' -> root.right = new Tree(n2);
                    }
                }
                else{
                    if(lr=='X')
                        clone(root,root,n1,n2);
                    else
                        insert(root,n1,n2,lr);
                }
            }
            try{Tree z=g.cloneTree(root);
                if(z==root)
                    System.out.println("0");
                else
                {
                    if(printInorder(root,z))
                        System.out.println("1");

                    else
                        System.out.println("0");

                }
            }catch(ClassCastException ignored){}
        }
    }
    public static boolean printInorder(Tree a,Tree b){
        if((a==null) && (b==null))
            return true;

        if(a!=null && b!=null)
        {
            boolean check=((a.data==b.data) && printInorder(a.left,b.left) && printInorder(a.right,b.right));

            if(a.random!=null && b.random!=null)
                return (check && (a.random.data==b.random.data));

            if(a.random==b.random)
                return check;

            return false;

        }
    
   /* if(a.random.data == b.random.data) 
		if(printInorder(a.left,b.left)==1) 
			if(printInorder(a.right,b.right)==1)
				return 1;*/
        return false;

    }
    public static void clone(Tree root,Tree proot,int n1,int n2){
        try{if(root==null && proot==null)
            return;
            assert root != null;
            if(n1==root.data){
                if(proot.data==n2)
                    root.random=proot;
                else{
                    clone(root,proot.left,n1,n2);
                    clone(root,proot.right,n1,n2);
                }
            }
            else{
                clone(root.left,proot,n1,n2);
                clone(root.right,proot,n1,n2);
            }}catch(NullPointerException ignored){}
    }
    public static void insert(Tree root,int n1,int n2,char lr){
        if(root==null)
            return;
        if(n1==root.data){
            switch (lr) {
                case 'L' -> root.left = new Tree(n2);
                case 'R' -> root.right = new Tree(n2);
            }
        }
        else{
            insert(root.left,n1,n2,lr);
            insert(root.right,n1,n2,lr);
        }
    }
}
// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}*/
class Solution {
    HashMap<Tree, Tree> nodeToClonedNode;

    public Solution() {
        nodeToClonedNode = new HashMap<>();
    }

    public Tree cloneTree(Tree tree){
        // add code here.
        if (tree == null) return null;

        Tree clonedNode = nodeToClonedNode.getOrDefault(tree, new Tree(tree.data));

        clonedNode.left = cloneTree(tree.left);
        clonedNode.right = cloneTree(tree.right);

        if (tree.random != null) {
            clonedNode.random = nodeToClonedNode.getOrDefault(tree.random, new Tree(tree.random.data));
        }

        nodeToClonedNode.put(tree, clonedNode);

        return clonedNode;
    }
}