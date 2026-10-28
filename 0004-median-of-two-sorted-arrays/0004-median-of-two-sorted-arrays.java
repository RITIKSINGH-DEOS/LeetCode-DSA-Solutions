
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] A = nums1;
        int[] B = nums2;

        if (A.length > B.length) {
            A = nums2;
            B = nums1;
        }

        int m = A.length;
        int n = B.length;

        int low = 0;
        int high = m;

        while (low <= high) {

            int partitionA = (low + high) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0)
                    ? Integer.MIN_VALUE : A[partitionA - 1];

            int minRightA = (partitionA == m)
                    ? Integer.MAX_VALUE : A[partitionA];

            int maxLeftB = (partitionB == 0)
                    ? Integer.MIN_VALUE : B[partitionB - 1];

            int minRightB = (partitionB == n)
                    ? Integer.MAX_VALUE : B[partitionB];

            if (maxLeftA <= minRightB &&
                maxLeftB <= minRightA) {

                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxLeftA, maxLeftB)
                          + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }

            } else if (maxLeftA > minRightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }

        return 0.0;
    }
}
