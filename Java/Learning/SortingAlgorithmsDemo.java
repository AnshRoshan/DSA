
import java.util.Arrays;

public class SortingAlgorithmsDemo {

    public static void main(String[] args) {
        // Example array to be sorted
        int[] array = { 5, 2, 7, 1, 9, 3 };

        // 1. Arrays.sort(int[] a) - Sorts the specified array into ascending numerical
        // order using the natural ordering.
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        System.out.println("Sorted array using Arrays.sort(): " + Arrays.toString(sortedArray));

        // 2. Arrays.parallelSort(int[] a) - Sorts the specified array into ascending
        // numerical order using a parallel sort algorithm.
        int[] parallelSortedArray = Arrays.copyOf(array, array.length);
        Arrays.parallelSort(parallelSortedArray);
        System.out.println("Sorted array using Arrays.parallelSort(): " + Arrays.toString(parallelSortedArray));

        // Bubble Sort
        int[] bubbleSortedArray = bubbleSort(Arrays.copyOf(array, array.length));
        System.out.println("Sorted array using Bubble Sort: " + Arrays.toString(bubbleSortedArray));

        // Selection Sort
        int[] selectionSortedArray = selectionSort(Arrays.copyOf(array, array.length));
        System.out.println("Sorted array using Selection Sort: " + Arrays.toString(selectionSortedArray));

        // Insertion Sort
        int[] insertionSortedArray = insertionSort(Arrays.copyOf(array, array.length));
        System.out.println("Sorted array using Insertion Sort: " + Arrays.toString(insertionSortedArray));

        // Merge Sort
        int[] mergeSortedArray = mergeSort(Arrays.copyOf(array, array.length));
        System.out.println("Sorted array using Merge Sort: " + Arrays.toString(mergeSortedArray));

        // Quick Sort
        int[] quickSortedArray = quickSort(Arrays.copyOf(array, array.length));
        System.out.println("Sorted array using Quick Sort: " + Arrays.toString(quickSortedArray));

        // Cycle Sort
        int[] cycleSortedArray = cycleSort(Arrays.copyOf(array, array.length));
        System.out.println("Sorted array using Cycle Sort: " + Arrays.toString(cycleSortedArray));
    }

    // Bubble Sort
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // Selection Sort
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    // Insertion Sort
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    // Merge Sort
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1)
            return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex])
                result[resultIndex++] = left[leftIndex++];
            else
                result[resultIndex++] = right[rightIndex++];
        }
        while (leftIndex < left.length)
            result[resultIndex++] = left[leftIndex++];
        while (rightIndex < right.length)
            result[resultIndex++] = right[rightIndex++];
        return result;
    }

    // Quick Sort
    public static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Cycle Sort
    public static int[] cycleSort(int[] arr) {
        int writes = 0;
        for (int cycleStart = 0; cycleStart < arr.length - 1; cycleStart++) {
            int item = arr[cycleStart];
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < arr.length; i++) {
                if (arr[i] < item)
                    pos++;
            }
            if (pos == cycleStart)
                continue;
            while (item == arr[pos])
                pos++;
            if (pos != cycleStart) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < arr.length; i++) {
                    if (arr[i] < item)
                        pos++;
                }
                while (item == arr[pos])
                    pos++;
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    writes++;
                }
            }
        }
        System.out.println(writes + " writes performed");
        return arr;
    }
}
