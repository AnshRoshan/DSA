import java.util.ArrayList;
import java.util.Arrays;

public class IterativeString {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("The subsets are :-" + generateSubsets(str));
        int[] num = { 1, 2, 3, 3 };
        System.out.println("The subsets are :-" + generateSubsetsNum(num));
    }

    static ArrayList<String> generateSubsets(String str) {
        ArrayList<String> subsets = new ArrayList<String>();
        String current = "";
        subsets.add(current);
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                subsets.add(current + ch);
            }
            current += str.charAt(i);
        }
        return subsets;
    }

    static ArrayList<ArrayList<Integer>> generateSubsetsNum(int[] arr) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        Arrays.sort(arr);
        int duplicate = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                duplicate++;
                for (int j = i + 1; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            }
        }
        ArrayList<Integer> inner = new ArrayList<>();
        for (int i = 0; i < arr.length - duplicate; i++) {
            for (int j = i; j < arr.length - duplicate; j++) {
                int num = arr[j];
                if (num == arr[j + 1]) {

                }
                // char ch = str.charAt(j);
                ArrayList<Integer> copy = new ArrayList<>(inner); // copy
                copy.add(num);
                subsets.add(copy);
            }
            inner.add(arr[i]);
        }
        return subsets;
    }

    // LEARN BIT MASKING----------------------

    // static ArrayList<ArrayList<Integer>> generateSubsetsNum(int[] arr) {
    // ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
    // // Sort the array to handle duplicates
    // Arrays.sort(arr);
    // int n = arr.length;
    // // Iterate through all possible subsets using bitmask
    // for (int i = 0; i < (1 << n); i++) {
    // ArrayList<Integer> subset = new ArrayList<>();
    // for (int j = 0; j < n; j++) {
    // // Check if j-th bit is set in the bitmask
    // if ((i & (1 << j)) > 0) {
    // subset.add(arr[j]);
    // }
    // }
    // subsets.add(subset);
    // }

    // return subsets;
    // }

}
