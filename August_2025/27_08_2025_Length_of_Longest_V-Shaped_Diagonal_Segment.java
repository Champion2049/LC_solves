class Solution {
    private int rows;
    private int cols;
    private int[] expectVals = new int[]{2, 2, 0};
    private int[][] dRC = new int[][]{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}}; 
    private int[][][] memo; 
    public int lenOfVDiagonal(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        if (rows == 0 || cols == 0) return 0;
        memo = new int[rows][cols][1 << 3];
        int max = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    for (int d = 0; d < 4; d++) {
                        max = Math.max(max, getLength(r, c, d, 1, grid, true));
                    }
                }
            }
        }

        return max;
    }

    private int getLength(int r, int c, int d, int expVal, int[][] grid, boolean canTurn) {
        if (r >= rows || r < 0 || c >= cols || c < 0) return 0;
        if (grid[r][c] != expVal) return 0;
        int idx = canTurn ? (1 << 2 | d) : d;
        if (memo[r][c][idx] > 0) return memo[r][c][idx];
        int max = 1 + getLength(r + dRC[d][0], c + dRC[d][1], d, expectVals[expVal], grid, canTurn);
        if (canTurn) {
            d = (d + 1) % 4;
            max = Math.max(max, 1 + getLength(r + dRC[d][0], c + dRC[d][1], d, expectVals[expVal], grid, false));
        }
        memo[r][c][idx] = max;
        return max;
    }
}
