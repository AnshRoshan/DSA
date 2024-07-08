import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * MinChanges
 */
public class MinChanges {

    static int minChanges(List<Integer> coins, int amount) {
        // if (amount == 0)
        // return 0;
        // if (amount < 0)
        // return -1;
        // int minimum = -1;
        // for (int coin : coins) {
        // int subVal = amount - coin;
        // int subCoins = minChanges(coins, subVal);
        // if (subCoins != -1) {
        // int gotcoin = subCoins + 1;
        // if (gotcoin < minimum || minimum == -1) {
        // minimum = gotcoin;
        // }
        // }
        // }
        // return minimum;
        return minChanges(coins, amount, new HashMap<>());
    }

    static int minChanges(List<Integer> coins, int amount, HashMap<Integer, Integer> memo) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (memo.containsKey(amount))
            return memo.get(amount);
        int minimum = -1;
        for (int coin : coins) {
            int subVal = amount - coin;
            int subCoins = minChanges(coins, subVal, memo);
            if (subCoins != -1) {
                int gotcoin = subCoins + 1;
                if (gotcoin < minimum || minimum == -1) {
                    minimum = gotcoin;
                }
            }
        }
        memo.put(amount, minimum);
        return minimum;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] number = { 1, 2, 3, 7, 11, 89, 23, 12, 78, 34 };
        // Arrays.sort(number, Comparator.reverseOrder());
        list.addAll(Arrays.asList(number));
        System.out.println("The minimum Sum possible for it:-" + minChanges(list, 3000));
    }
}
