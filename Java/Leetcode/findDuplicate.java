package Java.Leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class findDuplicate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static int findDuplicateBrute(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j])
					count++;
			}
			if (count >= 2)
				return nums[i];
		}
		return -1;
	}

	// this will modify the array. so the soultion is not accepted.
	public static int findDuplicateCyclicSort(int[] nums) {
		for (int i = 0; i < nums.length;) {
			int correct = nums[i] - 1;
			if (nums[i] != nums[correct]) {
				int temp = nums[correct];
				nums[correct] = nums[i];
				nums[i] = temp;
			} else
				i++;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)
				return nums[i];
		}
		return -1;
	}

	public static int findDuplicateHashSet(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return nums[i];
			set.add(nums[i]);
		}
		return -1;
	}

	public static int findDuplicateBooleanArray(int[] nums) {
		boolean[] set = new boolean[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			if (set[nums[i]])
				return nums[i];
			set[nums[i]] = true;
		}
		return -1;
	}
}