public class Main {
    public static void main(final String[] args) {
        final int[] nums1 = {1, 2, 3};
        final int[] nums2 = {4, 5, 6};
        final FindSumPairs findSumPairs = new FindSumPairs(nums1, nums2);

        System.out.println(findSumPairs.count(2));
        findSumPairs.add(1, 2);
        System.out.println(findSumPairs.count(2));
    }
}
