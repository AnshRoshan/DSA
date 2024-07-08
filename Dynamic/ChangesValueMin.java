import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ChangesValueMin
 */
public class ChangesValueMin {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] number = { 1, 2, 3, 7, 11, 89, 23, 12, 78, 34 };
        // Arrays.sort(number, Comparator.reverseOrder());
        list.addAll(Arrays.asList(number));
        System.out.println(list);
        System.out.println("The minimum Sum possible for it:-" + valueOfchanges(list, 3000));
    }

    private static List<Integer> valueOfchanges(List<Integer> coins, int amount) {
        if (amount == 0)
            return new ArrayList<>();
        if (amount < 0)
            return new ArrayList<>();
        int minimum = -1;
        for (int coin : coins) {
            int subVal = amount - coin;
            List<Integer> subCoins = valueOfchanges(coins, subVal);
            if (subCoins.get(0) != -1) {
                int gotcoin = subCoins.get(0) + 1;
                if (gotcoin < minimum || minimum == -1) {
                    minimum = gotcoin;
                }
            }
        }
        return new ArrayList<>();
    }
}
