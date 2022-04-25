import java.util.*;

class PeekingIterator implements Iterator<Integer> {
    private final int[] nums;
    private int ptr = 0;
    private int size = 0;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        int MAX_SIZE = 1005;
        nums = new int[MAX_SIZE];
        int i = 0;

        while (iterator.hasNext()) {
            int x = iterator.next();
            nums[i] = x;
            ++i;
            ++size;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
       return nums[ptr];
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
         int ans = nums[ptr];

         ++ptr;

         return ans;
    }

    @Override
    public boolean hasNext() {
        return ptr <= size - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        Iterator<Integer> iterator = nums.iterator();

        PeekingIterator peekingIterator = new PeekingIterator(iterator); // [1,2,3]

        System.out.println(peekingIterator.next());    // return 1, the pointer moves to the next element [1,2,3].
        System.out.println(peekingIterator.peek());    // return 2, the pointer does not move [1,2,3].
        System.out.println(peekingIterator.next());    // return 2, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.next());    // return 3, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.hasNext()); // return False
    }
}
