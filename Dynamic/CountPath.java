import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * CountPath
 */
public class CountPath {

    static int getPaths(List<List<String>> grid) {
        return getPaths(grid, 0, 0);
    }

    private static int getPaths(List<List<String>> grid, int row, int col) {
        // if (row == grid.size() || col == grid.get(row).size() ||
        // grid.get(row).get(col) == "x")
        // return 0;
        // if (row == grid.size() - 1 && col == grid.get(row).size() - 1)
        // return 1;
        // return getPaths(grid, row + 1, col) + getPaths(grid, row, col + 1);
        return getPaths(grid, row, col, new HashMap<List<Integer>, Integer>());
    }

    private static int getPaths(List<List<String>> grid, int row, int col, HashMap<List<Integer>, Integer> memo) {
        if (row == grid.size() || col == grid.get(row).size() || grid.get(row).get(col) == "x")
            return 0;
        if (row == grid.size() - 1 && col == grid.get(row).size() - 1)
            return 1;
        List<Integer> pos = List.of(row, col);
        if (memo.containsKey(pos))
            return memo.get(pos);

        int result = getPaths(grid, row + 1, col) + getPaths(grid, row, col + 1);
        memo.put(pos, result);
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> grid = new ArrayList<>();
        String[][] path = { { "o", "o", "x" }, { "o", "o", "o" }, { "o", "o", "o" } };
        Stream.of(path)
                .map(innerArray -> Arrays.asList(innerArray))
                .forEach(grid::add);
        System.out.println(grid);
        System.out.println("the Number of possible paths:--> " + getPaths(grid));
    }
}
