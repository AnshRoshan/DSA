import java.util.HashMap;

/**
 * Tribonaci
 */
public class Tribonaci {

    static int tribo(int num) {
        return tribo(num, new HashMap<>());
    }

    static int tribo(int num, HashMap<Integer, Integer> memo) {
        switch (num) {
            case 0:
                return 0;
            case 1:
                return 0;
            case 2:
                return 1;
        }
        if (memo.containsKey(num))
            return memo.get(num);
        int result = tribo(num - 1, memo) + tribo(num - 2, memo) + tribo(num - 3, memo);
        memo.put(num, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println("The tribonacci of the number " + n + " is equals to :--" + tribo(n));
    }
}
