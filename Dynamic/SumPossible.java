import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * SumPossible
 */
public class SumPossible {

    static boolean sumPos(List<Integer> num, int amount) {
        return sumPos(num, amount, new HashMap<>());
    }

    static boolean sumPos(List<Integer> num, int amount, HashMap<Integer, Boolean> memo) {
        if (amount == 0)
            return true;
        if (amount < 0)
            return false;
        if (memo.containsKey(amount))
            return memo.get(amount);
        for (int n : num) {
            int subSum = amount - n;
            boolean res = sumPos(num, subSum, memo);
            memo.put(subSum, res);
            return res;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] number = { 4, 2 };
        list.addAll(Arrays.asList(number));
        System.out.println("The Sum possible for it:-" + sumPos(list, 45));
    }
}
