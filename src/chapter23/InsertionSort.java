package chapter23;

public class InsertionSort {
    /** The method for sorting the numbers */
    public static void insertionSort(double[] list) {
        for (int i = 1; i < list.length; i++) {
            double currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }

            // Insert the current element into list[k+1]
            list[k + 1] = currentElement;
        }
    }
}
