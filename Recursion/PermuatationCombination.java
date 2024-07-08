import java.util.ArrayList;

public class PermuatationCombination {

    public static void main(String[] args) {

        String str = "abc";
        System.out.println("The Permutations are: ");
        generatePermutations(str, "");
        System.out.println("The Permutation are :-" + generatePermutationsAL(str, ""));
        System.out.println("The No. of  Permuataion are:--" + permutationCount(str, ""));
    }

    /**
     * 
     * @param str
     * @param prefix
     */
    static void generatePermutations(String str, String prefix) {
        // Base case: if the string is empty, print the permutation
        if (str.isEmpty()) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                // Move one character from the remaining string to the prefix
                String nst = str.substring(0, i) + str.substring(i + 1);
                generatePermutations(nst, prefix + str.charAt(i));
            }
        }
    }

    static ArrayList<String> generatePermutationsAL(String str, String curr) {

        ArrayList<String> list = new ArrayList<String>();
        if (str.isEmpty()) {
            list.add(curr);
            return list;
        } else {
            for (int i = 0; i < str.length(); i++) {
                String nstr = str.substring(0, i) + str.substring(i + 1);
                list.addAll(generatePermutationsAL(nstr, curr + str.charAt(i)));
            }
        }
        return list;

    }

    static int permutationCount(String str, String curr) {
        int count = 0;
        if (str.isEmpty()) {
            return 1;
        } else {
            for (int i = 0; i < str.length(); i++) {
                String nstr = str.substring(0, i) + str.substring(i + 1);
                count = count + (permutationCount(nstr, curr + str.charAt(i)));
            }
        }
        return count;

    }
}
