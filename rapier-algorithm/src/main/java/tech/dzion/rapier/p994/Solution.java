package tech.dzion.rapier.p994;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/4 22:09
 * @Description TODO
 */
public class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] tempGrid = new int[grid.length][grid[0].length];
        arrayCopy(grid, tempGrid);
        int count = 0;
        while (true) {
            boolean containOne = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int n = grid[i][j];
                    if (n == 1) {
                        containOne = true;
                    } else if (n >= 2) {
                        if (i - 1 >= 0 && tempGrid[i - 1][j] == 1) {
                            tempGrid[i - 1][j] = 2;
                        }
                        if (j - 1 >= 0 && tempGrid[i][j - 1] == 1) {
                            tempGrid[i][j - 1] = 2;
                        }
                        if (i + 1 < grid.length && tempGrid[i + 1][j] == 1) {
                            tempGrid[i + 1][j] = 2;
                        }
                        if (j + 1 < grid[i].length && tempGrid[i][j + 1] == 1) {
                            tempGrid[i][j + 1] = tempGrid[i][j + 1] * 2;
                        }
                    }
                }
            }
            if (Arrays.deepEquals(tempGrid, grid)) {
                if (containOne) {
                    return -1;
                } else {
                    return count;
                }
            }
            count++;
            arrayCopy(tempGrid, grid);
        }
    }

    private void arrayCopy(int[][] array, int[][] array2) {
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, array2[i], 0, array[i].length);
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new Solution().orangesRotting(grid));
        grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(new Solution().orangesRotting(grid));
        grid = new int[][]{{0, 2}};
        System.out.println(new Solution().orangesRotting(grid));
    }
}
