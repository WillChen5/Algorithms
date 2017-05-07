package ch4;

/**
 * Created by will on 2017/3/2.
 */
public class MaxSubArray {


    public static void main(String[] args) {
//        int a[] = {3, -1, 2, 5, -3, 4, -6, -7, 1, 8, -3, 5, 9};
//        Truple result = findMaxmumSubArray(a, 0, a.length - 1);
//        System.out.println(result);
        System.out.println(test());
    }

    public static int test() {
        try {
            System.out.println("&&&&&&&&&&");
            return 1;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            System.out.println("*******");
        }
        return 2;
    }

    private static Truple findMaxmumSubArray(int[] A, int low, int high) {
        if (high == low) {
            return new Truple(low, high, A[low]);
        } else {
            int mid = (low + high) / 2;
            Truple leftSum = findMaxmumSubArray(A, low, mid);
            Truple rightSum = findMaxmumSubArray(A, mid + 1, high);
            Truple crossSum = findMaxCrossingSubArray(A, low, mid, high);

            if (leftSum.sum > rightSum.sum && leftSum.sum > crossSum.sum) {
                return leftSum;
            } else if (rightSum.sum > leftSum.sum && rightSum.sum > crossSum.sum) {
                return rightSum;
            } else {
                return crossSum;
            }
        }
    }

    private static Truple findMaxCrossingSubArray(int[] A, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;
        for (int i = mid; i >= low; i--) {
            sum = sum + A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + A[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new Truple(maxLeft, maxRight, leftSum + rightSum);
    }

    static class Truple {
        public int leftIndex;
        public int rightIndex;
        public int sum;

        public Truple(int leftIndex, int rightIndex, int sum) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Truple{" +
                    "leftIndex=" + leftIndex +
                    ", rightIndex=" + rightIndex +
                    ", sum=" + sum +
                    '}';
        }
    }
}
