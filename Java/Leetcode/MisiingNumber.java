package Java.Leetcode;

public class MisiingNumber {
    public static void main(String[] args) {
        int[] arr = { 4, 0, 2, 1 };
        System.out.println(missingNumberCyclic(arr));
        System.out.println(missingNumberXOR(arr));
        System.out.println(missingNumberSUM(arr));
    }

    static public int missingNumberCyclic(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            } else
                i++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    public static int missingNumberXOR(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i;
            xor ^= nums[i];
        }
        xor ^= nums.length;
        return xor;
    }

    public static int missingNumberSUM(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        return (nums.length + 1) * nums.length / 2 - sum;
    }

    public int singleNumber(int[] nums) {
        int sol = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (final int num : nums)
                sum += (num >> i) & 1;
            sum %= 3;
            sol |= (sum << i);
        }
        return sol;
    }
}