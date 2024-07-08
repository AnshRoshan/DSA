import java.util.*;

public class ArraysRecursion {
	public static void main(String[] args) {
		int[] num = { 1, 2, 4, 5, 9, 8, 9, 9 };
		System.out.println("The array is sorted:-" + isSorted(num));
		System.out.println("The target [ 9 ] is found --> " + search(num, 9, 0));
		System.out.println("The target [ 9 ] is found --> " + searchIndex(num, 1, 0));
		System.out.println("The target [ 9 ] is found --> " + searchAllIndex(num, 9, 0));
		System.out.println("The target [ 9 ] is found --> " + searchAllIndex2(num, 9, 0));
		int[] arr = { 4, 5, 6, 7, 9, 1, 2 };
		System.out.println("The rotate binary search  [ 9 ] is found --> " + searchInRotatedArray(arr, 9));
		System.out.println("The array is sorted:-" + isSorted(new int[] { 2, 4, 1, 4 }));
		arr = new int[] { 1, 2, 2, 2, 2, 3, 3, 4 };
		ArrayList<ArrayList<Integer>> subsets = generateSubsetsNum(arr);
		System.out.println(subsets);
	}

	static boolean isSorted(int[] arr) {
		return isSorted(arr, 0);
	}

	static boolean isSorted(int[] arr, int index) {
		if (index == arr.length - 1)
			return true;
		return arr[index] <= arr[index + 1] && isSorted(arr, index + 1);
	}

	static boolean search(int[] arr, int target, int index) {
		if (index == arr.length)
			return false;
		return arr[index] == target || search(arr, target, index + 1);
	}

	static int searchIndex(int[] arr, int target, int index) {
		if (index == arr.length)
			return -1;
		if (arr[index] == target)
			return index;
		return searchIndex(arr, target, index + 1);
	}

	static ArrayList<Integer> searchAllIndex(int[] arr, int target, int index) {
		// ArrayList<Integer> sol=new ArrayList<Integer>();
		// return searchAllIndex( arr, target, index,sol );
		return searchAllIndex(arr, target, index, new ArrayList<Integer>());
	}

	static ArrayList<Integer> searchAllIndex(int[] arr, int target, int index, ArrayList<Integer> sol) {
		if (index == arr.length)
			return sol;
		if (arr[index] == target)
			sol.add(index);
		return searchAllIndex(arr, target, index + 1, sol);
	}

	// No the good approch as multiple arraylist is created
	static ArrayList<Integer> searchAllIndex2(int[] arr, int target, int index) {
		ArrayList<Integer> sol = new ArrayList<Integer>();
		if (index == arr.length)
			return sol;
		if (arr[index] == target)
			sol.add(index);
		sol.addAll(searchAllIndex2(arr, target, index + 1));
		return sol;
	}

	static int searchInRotatedArray(int[] arr, int target) {
		return searchInRotatedArray(arr, target, 0, arr.length - 1);
	}

	static int searchInRotatedArray(int[] arr, int target, int left, int right) {
		if (left > right)
			return -1;

		int mid = left + (right - left) / 2;

		if (arr[mid] == target)
			return mid;

		if (arr[left] <= arr[mid])
			if (arr[left] <= target && target < arr[mid])
				return searchInRotatedArray(arr, target, left, mid - 1);
			else
				return searchInRotatedArray(arr, target, mid + 1, right);
		else if (arr[mid] < target && target <= arr[right])
			return searchInRotatedArray(arr, target, mid + 1, right);
		else
			return searchInRotatedArray(arr, target, left, mid - 1);

	}

	static ArrayList<ArrayList<Integer>> generateSubsetsNum(int[] arr) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
		Arrays.sort(arr);

		ArrayList<Integer> inner = new ArrayList<>();
		subsets.add(new ArrayList<>(inner));
		for (int i = 0; i < arr.length; i++) {
			if (i > 0 && arr[i] == arr[i - 1])
				continue;
			for (int j = i; j < arr.length; j++) {
				if (j > 0 && arr[j] == arr[j - 1])
					continue;
				int num = arr[j];
				inner.add(num);
				subsets.add(new ArrayList<>(inner));
				inner.remove(inner.size() - 1);
			}
			inner.add(arr[i]);
		}
		return subsets;
	}
	// static ArrayList<ArrayList<Integer>> generateSubsetsNum(int[] arr) {
	// ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
	// Arrays.sort(arr);
	// int duplicate = 0;
	// for (int i = 0; i < arr.length - 1; i++) {
	// if (arr[i] == arr[i + 1]) {
	// duplicate++;
	// for (int j = i + 1; j < arr.length - 1; j++) {
	// arr[j] = arr[j + 1];
	// }
	// }
	// }
	// ArrayList<Integer> inner = new ArrayList<>();
	// for (int i = 0; i < arr.length - duplicate; i++) {
	// for (int j = i; j < arr.length - duplicate; j++) {
	// // char ch = str.charAt(j);
	// int num = arr[j];
	// ArrayList<Integer> copy = new ArrayList<>(inner); // copy
	// copy.add(num);
	// subsets.add(copy);
	// }
	// inner.add(arr[i]);
	// }
	// return subsets;
	// }

	// static ArrayList<ArrayList<Integer>> generateSubsetsNum(int[] arr) {
	// ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
	// Arrays.sort(arr); // Sort the array to handle duplicates
	// generateSubsets(arr, 0, new ArrayList<>(), subsets);
	// return subsets;
	// }

	// static void generateSubsets(int[] arr,int index, ArrayList<Integer> current,
	// ArrayList<ArrayList<Integer>> subsets) {
	// subsets.add(new ArrayList<>(current)); // Add the current subset

	// for (int i = index; i < arr.length; i++) {
	// // Skip duplicates
	// if (i > index && arr[i] == arr[i - 1]) {
	// continue;
	// }
	// current.add(arr[i]);
	// generateSubsets(arr, i + 1, current, subsets); // Recursively generate
	// subsets
	// int temp = current.removeLast();
	// }
	// }

}