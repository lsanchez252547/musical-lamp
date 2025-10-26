import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        System.out.println("\n\nBubble sort results ----------------------------------------------");
        long bubbleStart = System.nanoTime();
        ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
        long bubbleEnd = System.nanoTime();
        Lab4.outputList(bubbleSortedList);
        System.out.println("\nBubble sort time: " + (bubbleEnd - bubbleStart) + " nanoseconds");

        System.out.println("\n\nInsertion sort results -------------------------------------------");
        long insertionStart = System.nanoTime();
        ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);  
        long insertionEnd = System.nanoTime();
        Lab4.outputList(insertionSortedList);
        System.out.println("\nInsertion sort time: " + (insertionEnd - insertionStart) + " nanoseconds");
    }
}

class Lab4 {

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        // Create a copy so original list is not modified
        ArrayList<Integer> list = new ArrayList<>(integerList);

        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        return list;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        // Create a copy so original list is not modified
        ArrayList<Integer> list = new ArrayList<>(integerList);
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap elements
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no swaps occurred in this pass, the list is sorted
            if (!swapped) break;
        }

        return list;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList
