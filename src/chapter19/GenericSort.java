package chapter19;

public class GenericSort {
    public static void main(String[] args) {
        // Create an Integer array
        Integer[] intArray = {2, 4, 3};

        // Create a Double array
        Double[] doubleArray = {3.4, 1.3, -22.1};

        // Create a Character array
        Character[] charArray = {'a', 'J', 'r'};

        // Create a String array
        String[] stringArray = {"Tom", "Susan", "Kim"};

//    int[] list={1,2,3};
//    int[] list={new Integer(1),new Integer(2),new Integer(-1)};

        // Sort the arrays
        sort(intArray);
        sort(doubleArray);
        sort(charArray);
        sort(stringArray);
//    sort(list);

        // Display the sorted arrays
        System.out.print("Sorted Integer objects: ");
        printList(intArray);
        System.out.print("Sorted Double objects: ");
        printList(doubleArray);
        System.out.print("Sorted Character objects: ");
        printList(charArray);
        System.out.print("Sorted String objects: ");
        printList(stringArray);
    }

    /** Sort an array of comparable objects */
    public static <E extends Comparable<E>> void sort(E[] list) {
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i..list.length-1]
            currentMin = list[i];
            currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    /** Print an array of objects */
    public static void printList(Object[] list) {
        chapter13.GenericSort.printList(list);
    }
}
