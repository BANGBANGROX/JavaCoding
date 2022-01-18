import java.util.Scanner;
import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            s1.push(x);
            return;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s2.push(x);

        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }
    public int pop() {
        if (s1.isEmpty()) return -1;

        return s1.pop();
    }

    public int peek() {
         if (s1.isEmpty()) return -1;

         return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
