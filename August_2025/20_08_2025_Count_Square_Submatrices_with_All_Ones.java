class Solution {
    public int countSquares(int[][] matrix) {
        int[][] cache = new int[matrix.length + 1][matrix[0].length + 1] ;
        for(int r = matrix.length - 1 ; r >= 0 ; r--) {
            for(int c = matrix[0].length - 1 ; c >= 0 ; c--) {
                if(matrix[r][c] == 0) {
                    cache[r][c] = 0 ;
                    continue ;
                }
                cache[r][c] = Math.min(cache[r + 1][c], Math.min(cache[r][c + 1], cache[r + 1][c + 1])) + 1 ;
            }
        }

        int sum = 0 ;
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                sum += cache[i][j] ;
            }
        }

        return sum ;
    }
}
