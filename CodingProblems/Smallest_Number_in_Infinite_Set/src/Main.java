import java.util.TreeSet;

class SmallestInfiniteSet {
    private final TreeSet<Integer> treeSet;

    public SmallestInfiniteSet() {
        treeSet = new TreeSet<>();
        int MAX_N = 1005;

        for (int i = 1; i <= MAX_N; ++i) {
            treeSet.add(i);
        }
    }

    public int popSmallest() {
        int answer = treeSet.first();

        treeSet.remove(answer);

        return answer;
    }

    public void addBack(int num) {
        treeSet.add(num);
    }
}

public class Main {
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();

        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());

        smallestInfiniteSet.addBack(1);

        System.out.println(smallestInfiniteSet.popSmallest());
    }
}
