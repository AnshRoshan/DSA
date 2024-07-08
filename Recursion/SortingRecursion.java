import java.util.Arrays;

public class SortingRecursion {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 3, 1, 7, 5, 8, 9, 6 };
        System.out.println(Arrays.toString(nums));
        int[] num = { 7, 5, 8, 9, 6 };
        mergeSort2(num);
        System.out.println(Arrays.toString(num));
        nums = mergeSort(nums);
        System.out.println(Arrays.toString(nums));
        int[] numq = { 2, 4, 3, 1, 7, 5, 8, 9, 6 };
        quickSort(numq, 0, numq.length - 1);
        System.out.println(Arrays.toString(numq));

    }

    static int[] mergeSort(int[] arr) {
        if (arr.length <= 1 || arr == null) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];

        int lindex = 0;
        int rindex = 0;
        int mergindex = 0;

        while (lindex < left.length && rindex < right.length) {
            if (left[lindex] < right[rindex])
                merged[mergindex++] = left[lindex++];
            else
                merged[mergindex++] = right[rindex++];
        }

        // copy the rest element from left array
        while (lindex < left.length) {
            merged[mergindex++] = left[lindex++];
        }

        // copy the rest element from right array
        while (rindex < right.length) {
            merged[mergindex++] = right[rindex++];
        }

        return merged;
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSortInplace(arr, 0, arr.length - 1);
    }

    private static void mergeSortInplace(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSortInplace(arr, low, mid);
            mergeSortInplace(arr, mid + 1, high);
            mergeInplace(arr, low, mid, high);
        }
    }

    private static void mergeInplace(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1]; // Temporary array to store merged values
        int left = low; // Index for the left subarray
        int right = mid + 1; // Index for the right subarray
        int tempindex = 0; // Index for the temporary array

        // Merge elements from the two subarrays into the temporary array
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[tempindex++] = arr[left++];
            } else {
                temp[tempindex++] = arr[right++];
            }
        }

        // Copy any remaining elements from the left subarray to the temporary array
        while (left <= mid) {
            temp[tempindex++] = arr[left++];
        }

        // Copy any remaining elements from the right subarray to the temporary array
        while (right <= high) {
            temp[tempindex++] = arr[right++];
        }

        // Copy merged elements back to the original array
        for (left = low; left <= high; left++) {
            arr[left] = temp[left - low];
        }
    }

    static void quickSort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int start = low;
        int mid = low + (high - low) / 2;
        int end = high;
        int pivot = nums[mid];

        while (start <= end) {
            while (nums[start] < pivot) {
                start++;
            }
            while (nums[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        // now pivot is at right place ,now sort the other two half.
        quickSort(nums, low, end);
        quickSort(nums, start, high);

        // java uses dual-pivot
        // python uses timsort
        // rust uses introsort
    }

}