package chap6.heapsort;

public class MaxHeapSort {

    public void build(int[] A) {
        for (int i = A.length / 2; i >= 1; i--) {
            heapify(A, i - 1);
        }
    }

    private void heapify(int[] A, int i) {
        int l = left(i);
        int r = right(i);

        int largest = largest(A, i, l, r);

        if (largest != i) {
            exchange(A, i, largest);
            heapify(A, largest);
        }
    }

    private int left(int i) {
        return 2 * (i + 1)-1;
    }

    private int right(int i) {
        return 2 * (i + 1);
    }

    private void exchange(int[] A, int i1, int i2) {
        int temp = A[i1];
        A[i1] = A[i2];
        A[i2] = temp;
    }

    private int largest(int[] A, int i, int l, int r) {
        int largest = i;
        int length = A.length;
        if (l < length && A[l] > A[i]) {
            largest = l;
        }

        if (r < length && A[r] > A[largest]) {
            largest = r;
        }
        return largest;
    }

}
