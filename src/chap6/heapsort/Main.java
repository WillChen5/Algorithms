package chap6.heapsort;

/**
 * Created by will on 2017/5/7.
 */
public class Main {

    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        MaxHeapSort heapSort = new MaxHeapSort();
        heapSort.build(A);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
