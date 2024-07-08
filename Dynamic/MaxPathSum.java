import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * MaxPathSum
 */
public class MaxPathSum {

    private static int maxPath(List<List<Integer>> grid) {
        return maxPath(grid, 0, 0);
    }

    private static int maxPath(List<List<Integer>> grid, int row, int col) {
        // if (row == grid.size() || col == grid.get(row).size())
        // return 0;
        // if (row == grid.size() - 1 && col == grid.get(row).size() - 1)
        // return grid.get(row).get(col);
        // int bottom = maxPath(grid, row + 1, col);
        // int right = maxPath(grid, row, col + 1);
        // int result = grid.get(row).get(col) + Math.max(bottom, right);
        // System.out.println(bottom + " --- " + right + "---" + result);
        // return result;
        return maxPath(grid, 0, 0, new HashMap<>());
    }

    private static int maxPath(List<List<Integer>> grid, int row, int col, HashMap<List<Integer>, Integer> memo) {
        if (row == grid.size() || col == grid.get(row).size())
            return 0;
        if (row == grid.size() - 1 && col == grid.get(row).size() - 1)
            return grid.get(row).get(col);
        List<Integer> pos = List.of(row, col);
        if (memo.containsKey(pos))
            memo.get(pos);
        int bottom = maxPath(grid, row + 1, col, memo);
        int right = maxPath(grid, row, col + 1, memo);
        int result = grid.get(row).get(col) + Math.max(bottom, right);
        memo.put(pos, result);
        System.out.println(bottom + " --- " + right + "---" + result);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        Integer[][] number = { { 1, 1, 1 }, { 1, 8, 1 }, { 1, 1, 9 } };
        Stream.of(number)
                .map(rows -> Arrays.asList(rows))
                .forEach(grid::add);
        System.out.println(grid);
        System.out.println("The Max value Path:-" + maxPath(grid));
    }
}
