import java.util.HashMap;

public class Fibonaci {

    static int fib(int n) {
        return fib(n, new HashMap<Integer, Integer>());
    }

    static int fib(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1)
            return n;
        if (memo.containsKey(n))
            return memo.get(n);

        int sum = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, sum);
        return sum;
    }

    public static void main(String[] args) {
        int n = 999;
        System.out.println(fib(n));
    }

}
