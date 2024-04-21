package Java.Leetcode;

public class PositiveMissing {
	public static void main(String[] args) {
	}

	public int firstMissingPositiveCyclicSort(int[] nums) {
		for (int i = 0; i < nums.length;) {
			int val = nums[i] - 1;
			if (val >= 0 && val < nums.length && nums[i] != nums[val]) {
				int temp = nums[val];
				nums[val] = nums[i];
				nums[i] = temp;
			} else
				i++;
		}
		int i = 1;
		for (; i <= nums.length; i++) {
			if (nums[i - 1] != i)
				return i;
		}
		return i;
	}

	public int firstMissingPositiveBooleanArray(int[] nums) {
		boolean[] set = new boolean[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] <= nums.length)
				set[nums[i] - 1] = true;
		}
		for (int i = 0; i < set.length; i++)
			if (!set[i])
				return i + 1;
		return -1;
	}
}